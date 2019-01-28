package dev.ranggalabs.promo.model;

/**
 * Created by erlangga on 13/01/19.
 */
public class Discount {
    private int id;
    private String name;
    private int percentage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
