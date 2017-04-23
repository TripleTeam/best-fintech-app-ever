package com.aiaiai.bestfintechappever.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.aiaiai.bestfintechappever.adapter.OffersAdapter;
import com.aiaiai.bestfintechappever.core.App;
import com.aiaiai.bestfintechappever.data.letty_offer.LetyOfferRepository;
import com.aiaiai.bestfintechappever.model.LetyShopsOffer;
import com.aiaiai.bestfintechappever.model.Offer;
import com.aiaiai.bestfintechappever.model.vh.OnItemClickListener;

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
    public void onLettyOfferPrepared(@NonNull final List<LetyShopsOffer> offerList) {
        Context context = getContext();
        if (offersRecyclerView != null && context != null) {
            OnItemClickListener onItemClickListener = new OnItemClickListener() {
                @Override
                public void click(int position) {
                    LetyShopsOffer letyShopsOffer = offerList.get(position);
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(letyShopsOffer.getHref()));
                    browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    App.getAppContext().startActivity(browserIntent);
                }
            };
            OffersAdapter adapter = new OffersAdapter(context, new ArrayList<Offer>(), offerList, onItemClickListener);
            offersRecyclerView.setAdapter(adapter);
        }
    }
}
