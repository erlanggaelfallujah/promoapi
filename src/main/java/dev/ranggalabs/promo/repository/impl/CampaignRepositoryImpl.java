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

    @Override
    public List<Campaign> findCampaignActive(PromoRequestDto dto) {
        StringBuilder sql = new StringBuilder("SELECT * FROM campaign ");
        sql.append("WHERE start_date <= :date ");
        sql.append("AND end_date >= :date ");
        sql.append("AND min_amount <= :amount ");
        sql.append("AND max_amount >= :amount ");
        sql.append("AND mid = :mid ");
        sql.append("AND tid = :tid ");

        List<Campaign> entities = null;
        try (Connection conn = sql2o.open(); Query query = conn.createQuery(sql.toString())) {
            entities = query.addParameter("mid", dto.getMid())
                    .addParameter("tid", dto.getTid())
                    .addParameter("amount", dto.getAmount())
                    .addParameter("date", new SimpleDateFormat("yyyy-MM-dd").format(dto.getTransactionDate()))
                    .addColumnMapping("start_date", "startDate")
                    .addColumnMapping("end_date", "endDate")
                    .addColumnMapping("min_amount", "minAmount")
                    .addColumnMapping("max_amount", "maxAmount")
                    .addColumnMapping("reward_type", "rewardType")
                    .addColumnMapping("discount_id", "discountId")
                    .executeAndFetch(Campaign.class);
            return entities;
        }
    }
}
