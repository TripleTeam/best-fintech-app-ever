package com.aiaiai.bestfintechappever.fragment;

import android.content.Context;
import android.support.annotation.NonNull;

import com.aiaiai.bestfintechappever.adapter.OffersAdapter;
import com.aiaiai.bestfintechappever.core.App;
import com.aiaiai.bestfintechappever.data.letty_offer.LetyOfferRepository;
import com.aiaiai.bestfintechappever.model.LetyShopsOffer;
import com.aiaiai.bestfintechappever.model.Offer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

// TODO: 22.04.17 do not this for production
public class SecondFragment extends FirstFragment implements LetyOfferRepository.Callback {

    public static SecondFragment instance() {
        return new SecondFragment();
    }

    @Inject
    LetyOfferRepository letyOfferRepository;

    @Override
    protected void injectDependencies() {
        App.component().inject(this);
    }

    @Override
    public void initiateLoading() {
        letyOfferRepository.prepareOffers(this);
    }

    @Override
    public void onLettyOfferPrepared(@NonNull List<LetyShopsOffer> offerList) {
        Context context = getContext();
        if (offersRecyclerView != null && context != null) {
            OffersAdapter adapter = new OffersAdapter(context, new ArrayList<Offer>(), offerList, null);
            offersRecyclerView.setAdapter(adapter);
        }
    }
}
