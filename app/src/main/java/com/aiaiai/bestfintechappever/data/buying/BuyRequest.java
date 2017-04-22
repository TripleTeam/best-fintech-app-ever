package com.aiaiai.bestfintechappever.data.buying;

public class BuyRequest {
    public BuyRequest(long user_id, long biglion_id) {
        this.user_id = user_id;
        this.biglion_id = biglion_id;
    }

    long user_id;
    long biglion_id;

}
