package dev.ranggalabs.promo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.ranggalabs.promo.model.Reward;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erlangga on 13/01/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromoResponseDto extends PromoRequestDto {
    private String responseCode;
    private Double netAmount;
    private List<Reward> rewards;

    public PromoResponseDto() {
        rewards = new ArrayList<>();
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public void addReward(Reward reward){
        this.rewards.add(reward);
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }
}
