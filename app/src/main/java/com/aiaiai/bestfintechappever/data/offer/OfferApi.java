package com.aiaiai.bestfintechappever.data.offer;

import java.util.List;

import retrofit2.Call;

public interface OfferApi {
    Call<List<NetworkOffer>> getOffers();
}
