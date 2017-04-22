package com.aiaiai.bestfintechappever.model;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class OfferLetyShops {

    private long id;
    private String title;
    private String cashback;
    private String picUrl;

    public OfferLetyShops(long id, String title, String cashback, String picUrl) {
        this.id = id;
        this.title = title;
        this.cashback = cashback;
        this.picUrl = picUrl;
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

    public String getCashback() {
        return cashback;
    }

    public void setCashback(String cashback) {
        this.cashback = cashback;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
