package com.aiaiai.bestfintechappever.data;

import android.support.annotation.MainThread;

import com.aiaiai.bestfintechappever.model.Offer;

import java.util.List;

public interface OfferRepository {

    interface Callback {
        @MainThread
        void onOfferPrepared(List<Offer> offerList);
    }

    /**
     * implement Callback and check all view,
     * <p>
     * // TODO: 22.04.17 handle subscribe/unsubscribe
     * <p>
     * callback can be executed, when your view is already null
     */
    void prepareOffers(Callback callback);

}
