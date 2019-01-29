package dev.ranggalabs.promo.model;

/**
 * Created by erlangga on 13/01/19.
 */
public class Reward {
    private String responseCode;
    private Discount discount;
    private long campaignId;

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
