package com.aiaiai.bestfintechappever.data.offer;

import com.google.gson.annotations.SerializedName;

public class NetworkOffer {
    long id;
    String category;
    String description;
    String discount;
    String discounted;
    String href;
    @SerializedName("img_src_url")
    String imgSrcUrl;
    @SerializedName("img_url")
    String imgUrl;
    String price;

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getDiscount() {
        return discount;
    }

    public String getDiscounted() {
        return discounted;
    }

    public String getHref() {
        return href;
    }

    public String getImgSrcUrl() {
        return imgSrcUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getPrice() {
        return price;
    }
}
