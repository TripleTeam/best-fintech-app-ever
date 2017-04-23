package com.aiaiai.bestfintechappever.data.gifts;

import com.google.gson.annotations.SerializedName;

public class GiftRequest {
    @SerializedName("user_id")
    long userId;

    public GiftRequest(long userId) {
        this.userId = userId;
    }
}
