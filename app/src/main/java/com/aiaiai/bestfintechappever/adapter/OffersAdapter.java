package com.aiaiai.bestfintechappever.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.model.Offer;
import com.aiaiai.bestfintechappever.model.LetyShopsOffer;
import com.aiaiai.bestfintechappever.model.vh.OfferLetyShopsVH;
import com.aiaiai.bestfintechappever.model.vh.OfferVH;
import com.aiaiai.bestfintechappever.model.vh.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class OffersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int OFFER_BIGLION = 0;
    private final int OFFER_LETYSHOPS = 1;

    private LayoutInflater inflater;
    private List<Offer> offers;
    @Nullable
    private final OnItemClickListener biglion;
    private List<LetyShopsOffer> offersLetyShops = new ArrayList<>();
    private OnItemClickListener lettyListener;

    //biglion
    public OffersAdapter(Context context, List<Offer> offers, @Nullable OnItemClickListener biglion) {
        this.inflater = LayoutInflater.from(context);
        this.offers = offers;
        this.biglion = biglion;
        lettyListener = null;
    }

    public OffersAdapter(Context context, @NonNull List<Offer> offers, @NonNull List<LetyShopsOffer> offersLetyShops, OnItemClickListener lettyListener) {
        this(context, offers, null);
        this.offersLetyShops = offersLetyShops;
        this.lettyListener = lettyListener;
    }


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new OfferVH(inflater.inflate(R.layout.item_offer_biglion, parent, false), biglion);
            case 1:
                return new OfferLetyShopsVH(inflater.inflate(R.layout.item_offer_letyshops, parent, false), lettyListener);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                ((OfferVH) holder).bind(offers.get(position));
                break;
            case 1:
                ((OfferLetyShopsVH) holder).bind(offersLetyShops.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return offers.size() + offersLetyShops.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < offers.size()) {
            return 0;
        }
        return 1;
    }
}
