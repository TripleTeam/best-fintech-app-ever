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
    private String price;

    public Offer(long id, String title, String description, String picUrl, String price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
