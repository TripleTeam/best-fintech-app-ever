package com.aiaiai.bestfintechappever.data.letty_offer;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.aiaiai.bestfintechappever.model.LetyShopsOffer;

import java.util.List;

public interface LetyOfferRepository {

    interface Callback {
        @MainThread
        void onLettyOfferPrepared(@NonNull List<LetyShopsOffer> offerList);

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
