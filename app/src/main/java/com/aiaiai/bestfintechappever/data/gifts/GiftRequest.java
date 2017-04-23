package com.aiaiai.bestfintechappever.data.gifts;

import com.google.gson.annotations.SerializedName;

public class GiftRequest {
    @SerializedName("user_id")
    long userId;

    int type_id;

    public GiftRequest(long userId, int type) {
        this.userId = userId;
        this.type_id = type;
    }
}
