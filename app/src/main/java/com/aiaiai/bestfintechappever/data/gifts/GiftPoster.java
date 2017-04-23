package com.aiaiai.bestfintechappever.data.gifts;

import com.aiaiai.bestfintechappever.async.MainHandler;
import com.aiaiai.bestfintechappever.data.ApiRetrofitService;
import com.aiaiai.bestfintechappever.data.offer.NetworkOffer;
import com.aiaiai.bestfintechappever.data.offer.OfferMapper;
import com.aiaiai.bestfintechappever.model.Offer;
import com.aiaiai.bestfintechappever.util.AppConstants;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Response;

@Singleton
public class GiftPoster {

    private final ThreadPoolExecutor threadPoolExecutor;
    private final MainHandler mainHandler;
    private final ApiRetrofitService apiRetrofitService;
    private final OfferMapper offerMapper;

    @Inject
    public GiftPoster(ThreadPoolExecutor threadPoolExecutor, MainHandler mainHandler, ApiRetrofitService apiRetrofitService, OfferMapper offerMapper) {
        this.threadPoolExecutor = threadPoolExecutor;
        this.mainHandler = mainHandler;
        this.apiRetrofitService = apiRetrofitService;
        this.offerMapper = offerMapper;
    }

    public void requestGift(final Callback callback, final int type) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<NetworkOffer> response = apiRetrofitService.postGift(new GiftRequest(AppConstants.userId, type)).execute();
                    NetworkOffer networkOffer = response.body();
                    final Offer offer = offerMapper.toModel(networkOffer);
                    mainHandler.post(new MainHandler.OnMainThread() {
                        @Override
                        public void doOnMain() {
                            callback.showGift(offer);
                        }
                    });
                } catch (Exception e) {
                    if (e instanceof IOException) {
                        mainHandler.post(new MainHandler.OnMainThread() {
                            @Override
                            public void doOnMain() {
                                callback.onInternetError();
                            }
                        });
                    } else {
                        mainHandler.post(new MainHandler.OnMainThread() {
                            @Override
                            public void doOnMain() {
                                callback.notEnoughMoney();
                            }
                        });
                    }
                }

            }
        });
    }


    public interface Callback {

        void showGift(Offer offer);

        void notEnoughMoney();

        void onInternetError();
    }

}
