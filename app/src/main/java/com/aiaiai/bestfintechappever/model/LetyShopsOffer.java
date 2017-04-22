package com.aiaiai.bestfintechappever.model;

import com.aiaiai.bestfintechappever.util.AppConstants;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class LetyShopsOffer {

    private long id;
    @SerializedName("description")
    private String title;
    @SerializedName("cash_back")
    private String cashback;
    @SerializedName("img_url_local")
    private String picUrl;

    public LetyShopsOffer(long id, String title, String cashback, String picUrl) {
        this.id = id;
        this.title = title;
        this.cashback = cashback;
        this.picUrl = picUrl;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCashback() {
        return cashback;
    }

    public String getPicUrl() {
        return AppConstants.baseUrl + "/" + picUrl;
    }

}
