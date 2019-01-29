package dev.ranggalabs.promo.repository.impl;

import dev.ranggalabs.promo.dto.PromoRequestDto;
import dev.ranggalabs.promo.model.Campaign;
import dev.ranggalabs.promo.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by erlangga on 13/01/19.
 */
@Repository
public class CampaignRepositoryImpl implements CampaignRepository {

    @Autowired
    private Sql2o sql2o;

    /*
        SELECT id,name,reward_type,discount_id FROM promo.campaign c
        JOIN promo.promo_map pm ON c.id = pm.campaign_id
        WHERE c.start_date <= '2019-01-28' AND c.end_date>= '2019-01-28'
        AND c.min_amount<= 10000 AND c.max_amount>= 15000
        AND c.mid = 'midtest' AND c.tid='tidtest';
     */

    @Override
    public List<Campaign> findCampaignActive(PromoRequestDto dto) {
        StringBuilder sql = new StringBuilder("SELECT id,name,reward_type,discount_id,campaign_id FROM campaign c ");
        sql.append("JOIN promo_map pm ON c.id=pm.campaign_id ");
        sql.append("WHERE c.start_date <= :date ");
        sql.append("AND c.end_date >= :date ");
        sql.append("AND c.min_amount <= :amount ");
        sql.append("AND c.max_amount >= :amount ");
        sql.append("AND c.mid = :mid ");
        sql.append("AND c.tid = :tid ");

        List<Campaign> entities = null;
        try (Connection conn = sql2o.open(); Query query = conn.createQuery(sql.toString())) {
            entities = query.addParameter("mid", dto.getMid())
                    .addParameter("tid", dto.getTid())
                    .addParameter("amount", dto.getAmount())
                    .addParameter("date", new SimpleDateFormat("yyyy-MM-dd").format(dto.getTransactionDate()))
                    .addColumnMapping("reward_type", "rewardType")
                    .addColumnMapping("discount_id", "discountId")
                    .addColumnMapping("campaign_id", "id")
                    .executeAndFetch(Campaign.class);
            return entities;
        }
    }
}
