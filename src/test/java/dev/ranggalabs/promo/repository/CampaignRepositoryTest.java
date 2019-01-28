package dev.ranggalabs.promo.repository;

import dev.ranggalabs.promo.Application;
import dev.ranggalabs.promo.dto.PromoRequestDto;
import dev.ranggalabs.promo.model.Campaign;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by erlangga on 13/01/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CampaignRepositoryTest {

    @Autowired
    private CampaignRepository campaignRepository;

    @Test
    public void testFindCampaignNotFound(){
        PromoRequestDto dto = new PromoRequestDto();
        dto.setAmount(1000D);
        dto.setMid("mid_test_not_found");
        dto.setTid("tid_test_not_found");
        dto.setTransactionDate(new Date());
        List<Campaign> campaigns = campaignRepository.findCampaignActive(dto);
        Assert.assertTrue(campaigns.size()==0);
    }

    @Test
    public void testFindCampaignFound(){
        PromoRequestDto dto = new PromoRequestDto();
        dto.setAmount(1500D);
        dto.setMid("mid_test_found");
        dto.setTid("tid_test_found");
        dto.setTransactionDate(new Date());
        List<Campaign> campaigns = campaignRepository.findCampaignActive(dto);
        Assert.assertTrue(campaigns.size()==1);
    }

}
