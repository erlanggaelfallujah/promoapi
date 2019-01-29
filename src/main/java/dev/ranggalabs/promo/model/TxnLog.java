package dev.ranggalabs.promo.model;

import java.util.Date;

/**
 * Created by erlangga on 29/01/19.
 */
public class TxnLog {
    private String mid;
    private String tid;
    private Date transactionDate;
    private double amount;
    private double nettAmount;
    private String responseCode;
    private String refNumber;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getNettAmount() {
        return nettAmount;
    }

    public void setNettAmount(double nettAmount) {
        this.nettAmount = nettAmount;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }
}
