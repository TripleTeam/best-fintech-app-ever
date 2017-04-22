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
    private final String oldPrice;
    private final String newPrice;

    public Offer(long id, String title, String description, String picUrl, String oldPrice, String newPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
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

    public String getOldPrice() {
        return oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }
}
