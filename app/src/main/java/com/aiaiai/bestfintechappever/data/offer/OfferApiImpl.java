package com.aiaiai.bestfintechappever.data.offer;


import com.aiaiai.bestfintechappever.data.ApiRetrofitService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class OfferApiImpl implements OfferApi {

    private final ApiRetrofitService apiRetrofitService;

    @Inject
    OfferApiImpl(ApiRetrofitService apiRetrofitService) {
        this.apiRetrofitService = apiRetrofitService;
    }

    @Override
    public Call<List<NetworkOffer>> getOffers() {
        return apiRetrofitService.getSuperOffers();
    }
}
