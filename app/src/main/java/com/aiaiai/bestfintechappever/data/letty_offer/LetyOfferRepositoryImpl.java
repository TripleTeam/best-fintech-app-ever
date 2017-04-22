package com.aiaiai.bestfintechappever.data.letty_offer;

import com.aiaiai.bestfintechappever.async.MainHandler;
import com.aiaiai.bestfintechappever.data.ApiRetrofitService;
import com.aiaiai.bestfintechappever.data.letty_offer.LetyOfferRepository;
import com.aiaiai.bestfintechappever.model.LetyShopsOffer;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Inject;

public class LetyOfferRepositoryImpl implements LetyOfferRepository {

    private final ThreadPoolExecutor threadPoolExecutor;
    private final MainHandler mainHandler;
    private final ApiRetrofitService apiRetrofitService;

    @Inject
    LetyOfferRepositoryImpl(ThreadPoolExecutor threadPoolExecutor, MainHandler mainHandler, ApiRetrofitService apiRetrofitService) {
        this.threadPoolExecutor = threadPoolExecutor;
        this.mainHandler = mainHandler;
        this.apiRetrofitService = apiRetrofitService;
    }

    @Override
    public void prepareOffers(final Callback callback) {

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<LetyShopsOffer> offers;
                try {
                    offers = apiRetrofitService.getLettyOffers().execute().body();
                } catch (Exception e) {
                    offers = null;
                }

                final List<LetyShopsOffer> finalOffers = offers;
                mainHandler.post(new MainHandler.OnMainThread() {
                    @Override
                    public void doOnMain() {
                        if (finalOffers == null) {
                            callback.onError();
                        } else {
                            callback.onLettyOfferPrepared(finalOffers);
                        }
                    }
                });
            }
        });


    }
}
