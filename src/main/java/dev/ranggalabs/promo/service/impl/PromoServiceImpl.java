package dev.ranggalabs.promo.service.impl;

import dev.ranggalabs.promo.dto.PromoRequestDto;
import dev.ranggalabs.promo.dto.PromoResponseDto;
import dev.ranggalabs.promo.model.Campaign;
import dev.ranggalabs.promo.model.Discount;
import dev.ranggalabs.promo.model.Reward;
import dev.ranggalabs.promo.repository.CampaignRepository;
import dev.ranggalabs.promo.repository.DiscountRepository;
import dev.ranggalabs.promo.service.PromoService;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by erlangga on 13/01/19.
 */
@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private DiscountRepository discountRepository;

    private static final int REWARD_TYPE_DISCOUNT = 1;

    @Override
    public Single<PromoResponseDto> process(PromoRequestDto dto) {
        Observable<List<Campaign>> campaignsObs = Observable.just(campaignRepository.findCampaignActive(dto));
        PromoResponseDto responseDto = new PromoResponseDto();

        return Single.fromObservable(campaignsObs.map(campaigns -> {
            if(campaigns==null || campaigns.isEmpty()){
                Reward reward = new Reward();
                reward.setResponseCode("A1");
                responseDto.addReward(reward);
                return responseDto;
            }

            for(Campaign campaign : campaigns){
                if(campaign.getRewardType()== REWARD_TYPE_DISCOUNT){
                    Observable<Discount> discountObs = Observable.fromIterable(discountRepository.findOne(campaign.getDiscountId()));
                    discountObs.doOnEach(new Observer<Discount>() {
                        Reward reward = new Reward();

                        @Override
                        public void onSubscribe(Disposable disposable) {
                            System.out.println("onSubscription");
                        }

                        @Override
                        public void onNext(Discount discount) {
                            System.out.println("onNext");

                            int percentage = discount.getPercentage();
                            double amountTrx = responseDto.getNetAmount()!=null ? responseDto.getNetAmount() : dto.getAmount();
                            double nettAmount = (percentage * amountTrx) / 100;
                            responseDto.setNetAmount(amountTrx-nettAmount);

                            reward.setDiscount(discount);
                            responseDto.addReward(reward);
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            reward.setResponseCode("X0");
                            System.out.println("onError => " + throwable.getLocalizedMessage());
                        }

                        @Override
                        public void onComplete() {
                            System.out.println("onComplete");
                            reward.setResponseCode("00");
                            responseDto.setResponseCode("00");
                        }
                    }).subscribe();

                }
            }

            System.out.println("return response");
            return responseDto;
        }));
    }
}
