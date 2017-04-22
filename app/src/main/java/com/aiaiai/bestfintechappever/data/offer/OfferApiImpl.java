package com.aiaiai.bestfintechappever.data.offer;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

public class OfferApiImpl implements OfferApi {

    @Inject
    OfferApiImpl () {

    }

    @Override
    public Callable<List<NetworkOffer>> getOffers() {
        return null;
    }
}
