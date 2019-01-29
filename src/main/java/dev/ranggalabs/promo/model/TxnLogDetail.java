package dev.ranggalabs.promo.model;

/**
 * Created by erlangga on 29/01/19.
 */
public class TxnLogDetail {
    private Integer discountId;
    private String responseCode;
    private int campaignId;
    private Double remainingAmount;
    private long txnLogId;

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public Double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public long getTxnLogId() {
        return txnLogId;
    }

    public void setTxnLogId(long txnLogId) {
        this.txnLogId = txnLogId;
    }
}
