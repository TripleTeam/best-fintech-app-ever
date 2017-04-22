package com.aiaiai.bestfintechappever.data.offer;

import com.aiaiai.bestfintechappever.async.MainHandler;
import com.aiaiai.bestfintechappever.data.OfferRepository;

import java.util.concurrent.ThreadPoolExecutor;

public class NetworkOfferRepository implements OfferRepository {

    private final ThreadPoolExecutor threadPoolExecutor;
    private final MainHandler mainHandler;

    NetworkOfferRepository(ThreadPoolExecutor threadPoolExecutor, MainHandler mainHandler) {

        this.threadPoolExecutor = threadPoolExecutor;
        this.mainHandler = mainHandler;
    }

    @Override
    public void prepareOffers(Callback callback) {
        threadPoolExecutor.execute(new Runnable() {


            @Override
            public void run() {
                mainHandler.post(new MainHandler.OnMainThread() {
                    @Override
                    public void doOnMain() {

                    }
                });
            }
        });


    }
}
