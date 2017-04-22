package com.aiaiai.bestfintechappever.data.history;

import com.aiaiai.bestfintechappever.data.offer.NetworkOffer;
import com.google.gson.annotations.SerializedName;

public class HistoryItem {
    String coupon;
    NetworkOffer offer;
    @SerializedName("pdf_url")
    String pdfUrl;
    String timestamp;

    public HistoryItem(String coupon, NetworkOffer offer, String pdfUrl, String timestamp) {
        this.coupon = coupon;
        this.offer = offer;
        this.pdfUrl = pdfUrl;
        this.timestamp = timestamp;
    }

    public String getCoupon() {
        return coupon;
    }

    public NetworkOffer getOffer() {
        return offer;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
