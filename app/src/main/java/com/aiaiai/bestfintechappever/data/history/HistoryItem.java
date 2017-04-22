package com.aiaiai.bestfintechappever.data.history;

import com.aiaiai.bestfintechappever.data.offer.NetworkOffer;
import com.google.gson.annotations.SerializedName;

public class HistoryItem {
    String coupon;
    NetworkOffer offer;
    @SerializedName("pdf_url")
    String pdfUrl;
    String timestamp;
}
