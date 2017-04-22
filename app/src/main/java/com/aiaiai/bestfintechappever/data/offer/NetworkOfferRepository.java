package com.aiaiai.bestfintechappever.data.offer;

import com.aiaiai.bestfintechappever.async.MainHandler;
import com.aiaiai.bestfintechappever.model.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Inject;

public class NetworkOfferRepository implements OfferRepository {

    private final ThreadPoolExecutor threadPoolExecutor;
    private final MainHandler mainHandler;
    private final OfferApi offerApi;
    private final OfferMapper mapper;
    private final List<Offer> offerList = new ArrayList<>();

    @Inject
    NetworkOfferRepository(ThreadPoolExecutor threadPoolExecutor, MainHandler mainHandler, OfferApi offerApi, OfferMapper mapper) {
        this.threadPoolExecutor = threadPoolExecutor;
        this.mainHandler = mainHandler;
        this.offerApi = offerApi;
        this.mapper = mapper;
    }

    @Override
    public void prepareOffers(final Callback callback) {
        if (offerList.isEmpty()) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    List<NetworkOffer> offers;
                    try {
                        offers = offerApi.getOffers().execute().body();
                    } catch (Exception e) {
                        offers = null;
                    }

                    final List<Offer> domainOffers;
                    if (offers != null) {
                        domainOffers = mapper.toModel(offers);
                    } else {
                        domainOffers = null;
                    }

                    mainHandler.post(new MainHandler.OnMainThread() {
                        @Override
                        public void doOnMain() {
                            if (domainOffers == null) {
                                callback.onError();
                            } else {
                                offerList.addAll(domainOffers);
                                callback.onOfferPrepared(domainOffers);
                            }
                        }
                    });
                }
            });


        } else {
            callback.onOfferPrepared(offerList);
        }
    }
}
