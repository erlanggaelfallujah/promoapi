package dev.ranggalabs.promo.repository;

import dev.ranggalabs.promo.model.TxnLog;

/**
 * Created by erlangga on 29/01/19.
 */
public interface TxnLogRepository {
    Long save(TxnLog txnLog);
}
