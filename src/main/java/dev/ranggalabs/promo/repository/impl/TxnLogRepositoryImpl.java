package dev.ranggalabs.promo.repository.impl;

import dev.ranggalabs.promo.model.TxnLog;
import dev.ranggalabs.promo.repository.TxnLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

/**
 * Created by erlangga on 29/01/19.
 */
@Repository
public class TxnLogRepositoryImpl implements TxnLogRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Long save(TxnLog txnLog) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO txn_log(mid,tid,transaction_date,amount,nett_amount,response_code,ref_number) ");
        sql.append(" VALUES(:mid,:tid,:transactionDate,:amount,:nettAmount,:responseCode,:refNumber)");

        try(Connection conn = sql2o.beginTransaction(); Query query = conn.createQuery(sql.toString())){
            query.addParameter("mid",txnLog.getMid());
            query.addParameter("tid",txnLog.getTid());
            query.addParameter("transactionDate",txnLog.getTransactionDate());
            query.addParameter("amount",txnLog.getAmount());
            query.addParameter("nettAmount",txnLog.getNettAmount());
            query.addParameter("responseCode",txnLog.getResponseCode());
            query.addParameter("refNumber",txnLog.getRefNumber());
            query.executeUpdate();
            conn.commit();

            if (conn.getResult() > 0) {
                return conn.getKey(Long.class);
            }
        }
        return null;
    }
}
