package com.aiaiai.bestfintechappever.model;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class Offer {

    private long id;
    private String title;
    private String description;
    private String picUrl;
    private final String cashbackValue;
    private final String price;
    private final String percent;

    public Offer(long id, String title, String description, String picUrl, String cashbackValue, String price, String percent) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.cashbackValue = cashbackValue;
        this.price = price;
        this.percent = percent;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getCashbackValue() {
        return cashbackValue;
    }

    public String getPrice() {
        return price;
    }

    public String getPercent() {
        return percent;
    }
}
