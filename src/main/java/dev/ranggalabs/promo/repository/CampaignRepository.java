package dev.ranggalabs.promo.repository;

import dev.ranggalabs.promo.dto.PromoRequestDto;
import dev.ranggalabs.promo.model.Campaign;

import java.util.Date;
import java.util.List;

/**
 * Created by erlangga on 13/01/19.
 */
public interface CampaignRepository{
    List<Campaign> findCampaignActive(PromoRequestDto dto);
}
