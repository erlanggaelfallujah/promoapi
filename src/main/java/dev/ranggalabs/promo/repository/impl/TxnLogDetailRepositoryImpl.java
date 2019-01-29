package dev.ranggalabs.promo.repository.impl;

import dev.ranggalabs.promo.model.TxnLogDetail;
import dev.ranggalabs.promo.repository.TxnLogDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

/**
 * Created by erlangga on 29/01/19.
 */
@Repository
public class TxnLogDetailRepositoryImpl implements TxnLogDetailRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void save(TxnLogDetail txnLogDetail) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO txn_log_detail(discount_id,response_code,campaign_id,remaining_amount,txn_log_id) ");
        sql.append(" VALUES(:discountId,:responseCode,:campaignId,:remainingAmount,:txnLogId)");

        try(Connection conn = sql2o.beginTransaction(); Query query = conn.createQuery(sql.toString())){
            query.addParameter("discountId",txnLogDetail.getDiscountId());
            query.addParameter("responseCode",txnLogDetail.getResponseCode());
            query.addParameter("campaignId",txnLogDetail.getCampaignId());
            query.addParameter("remainingAmount",txnLogDetail.getRemainingAmount());
            query.addParameter("txnLogId",txnLogDetail.getTxnLogId());
            query.executeUpdate();
            conn.commit();
        }
    }
}
