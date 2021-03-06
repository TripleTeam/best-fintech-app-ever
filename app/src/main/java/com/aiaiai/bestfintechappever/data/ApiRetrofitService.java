package com.aiaiai.bestfintechappever.data;

import com.aiaiai.bestfintechappever.data.buying.BuyRequest;
import com.aiaiai.bestfintechappever.data.cashback.Cashback;
import com.aiaiai.bestfintechappever.data.gifts.GiftRequest;
import com.aiaiai.bestfintechappever.data.history.HistoryItem;
import com.aiaiai.bestfintechappever.data.offer.NetworkOffer;
import com.aiaiai.bestfintechappever.model.LetyShopsOffer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRetrofitService {

    @GET("biglion/offers")
    Call<List<NetworkOffer>> getSuperOffers();

    @GET("letyshops/offers")
    Call<List<LetyShopsOffer>> getLettyOffers();

    @GET("user/get_cashback")
    Call<Cashback> getCashBack(@Query("user_id") long userId);

    @GET("user/get_history")
    Call<List<HistoryItem>> getHistory(@Query("user_id") long userId);


    @POST("biglion/buy")
    Call<Cashback> postBuy(@Body BuyRequest buyRequest);

    @POST("biglion/buy_random_for_cashback")
    Call<NetworkOffer> postGift(@Body GiftRequest buyRequest);

}
