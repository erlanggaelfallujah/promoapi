package dev.ranggalabs.promo.service;

import dev.ranggalabs.promo.Application;
import dev.ranggalabs.promo.dto.PromoRequestDto;
import dev.ranggalabs.promo.dto.PromoResponseDto;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subscribers.TestSubscriber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
        PromoRequestDto dto = new PromoRequestDto();
        dto.setAmount(1500D);
        dto.setMid("mid_test_found");
        dto.setTid("tid_test_found");
        dto.setTransactionDate(new Date());

        Single<PromoResponseDto> response = promoService.process(dto);
        PromoResponseDto responseDto = response.blockingGet();
        Assert.assertTrue(responseDto.getResponseCode().equals("00"));
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

}
