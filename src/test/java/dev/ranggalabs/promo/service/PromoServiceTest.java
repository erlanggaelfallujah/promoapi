package dev.ranggalabs.promo.service;

import dev.ranggalabs.promo.Application;
import dev.ranggalabs.promo.dto.PromoRequestDto;
import dev.ranggalabs.promo.dto.PromoResponseDto;
import io.reactivex.Single;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

import static org.hamcrest.core.Is.is;

/**
 * Created by erlangga on 07/02/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PromoServiceTest {

    @Autowired
    private PromoService promoService;

    @Test
    public void testNormalPromoService(){
        for(int i=0;i<100;i++){
            PromoRequestDto dto = new PromoRequestDto();
            dto.setAmount(new Double(getRandomNumberInRange(1000,2000)));
            dto.setMid("mid_test_found");
            dto.setTid("tid_test_found");
            dto.setTransactionDate(new Date());

            Single<PromoResponseDto> response = promoService.process(dto);
            PromoResponseDto responseDto = response.blockingGet();
            Assert.assertThat(responseDto.getResponseCode(),is("00"));
            Assert.assertThat(responseDto.getRewards().size(),is(1));
            Assert.assertThat(responseDto.getRewards().get(0).getResponseCode(),is("00"));
            Assert.assertThat(responseDto.getRewards().get(0).getDiscount().getName(),is("test_discount_5%"));
            Assert.assertThat(responseDto.getNetAmount(),is((dto.getAmount()-((dto.getAmount()*responseDto.getRewards().get(0).getDiscount().getPercentage())/100))));
        }
    }

    @Test
    public void testPromoNotFound(){
        PromoRequestDto dto = new PromoRequestDto();
        dto.setAmount(150000D);
        dto.setMid("mid_test_found");
        dto.setTid("tid_test_found");
        dto.setTransactionDate(new Date());

        Single<PromoResponseDto> response = promoService.process(dto);
        PromoResponseDto promoResponseDto = response.blockingGet();
        Assert.assertThat(promoResponseDto.getResponseCode(),is("A1"));
        Assert.assertThat(promoResponseDto.getNetAmount(),is(dto.getAmount()));
    }

    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}
