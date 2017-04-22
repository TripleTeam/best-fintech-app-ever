package com.aiaiai.bestfintechappever.data;

import com.aiaiai.bestfintechappever.data.offer.NetworkOffer;
import com.aiaiai.bestfintechappever.model.LetyShopsOffer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRetrofitService {

    @GET("biglion/offers")
    Call<List<NetworkOffer>> getSuperOffers();

    @GET("letyshops/offers")
    Call<List<LetyShopsOffer>> getLettyOffers();
}
