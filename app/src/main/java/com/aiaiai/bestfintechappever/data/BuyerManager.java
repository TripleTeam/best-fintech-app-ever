package com.aiaiai.bestfintechappever.data;

import android.support.annotation.MainThread;

import com.aiaiai.bestfintechappever.async.MainHandler;
import com.aiaiai.bestfintechappever.data.buying.BuyRequest;
import com.aiaiai.bestfintechappever.data.cashback.Cashback;
import com.aiaiai.bestfintechappever.model.Offer;

import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BuyerManager {
    private final ThreadPoolExecutor threadPoolExecutor;
    private final MainHandler mainHandler;
    private final ApiRetrofitService apiRetrofitService;

    public interface Callback {
        @MainThread
        void onBought(Offer offer, Cashback cashback);

        void onErrorBought();
    }

    @Inject
    public BuyerManager(ThreadPoolExecutor threadPoolExecutor, MainHandler mainHandler, final ApiRetrofitService apiRetrofitService) {
        this.threadPoolExecutor = threadPoolExecutor;
        this.mainHandler = mainHandler;
        this.apiRetrofitService = apiRetrofitService;
    }

    public void postBuying(final Offer offer, final Callback callback) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    final Cashback cashback = apiRetrofitService.postBuy(new BuyRequest(0L, offer.getId())).execute().body();
                    if (cashback != null) {
                        mainHandler.post(new MainHandler.OnMainThread() {
                            @Override
                            public void doOnMain() {
                                callback.onBought(offer, cashback);
                            }
                        });
                    } else {
                        throw new RuntimeException("not succeful");
                    }
                } catch (Exception e) {
                    mainHandler.post(new MainHandler.OnMainThread() {
                        @Override
                        public void doOnMain() {
                            callback.onErrorBought();
                        }
                    });
                }
            }
        });
    }

}
