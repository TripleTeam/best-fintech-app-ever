package com.aiaiai.bestfintechappever.data.offer;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.aiaiai.bestfintechappever.model.Offer;

import java.util.List;

public interface OfferRepository {

    interface Callback {
        @MainThread
        void onOfferPrepared(@NonNull List<Offer> offerList);

        void onError();
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
