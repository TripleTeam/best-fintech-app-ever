package com.aiaiai.bestfintechappever.data.offer;

import java.util.List;
import java.util.concurrent.Callable;

public interface OfferApi {
    Callable<List<NetworkOffer>> getOffers();
}
