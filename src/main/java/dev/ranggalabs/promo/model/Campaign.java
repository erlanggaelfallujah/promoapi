package dev.ranggalabs.promo.model;

import java.util.Date;

/**
 * Created by erlangga on 13/01/19.
 */
public class Campaign {
    private long id;
    private String name;
    //private String mid;
    //private String tid;
    //private Date startDate;
    //private Date endDate;
    //private double minAmount;
    //private double maxAmount;
    private int rewardType;
    private int discountId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRewardType() {
        return rewardType;
    }

    public void setRewardType(int rewardType) {
        this.rewardType = rewardType;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
