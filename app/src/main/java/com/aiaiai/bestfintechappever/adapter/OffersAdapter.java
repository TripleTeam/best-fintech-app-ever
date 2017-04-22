package com.aiaiai.bestfintechappever.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.model.Offer;
import com.aiaiai.bestfintechappever.model.vh.OfferVH;

import java.util.List;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class OffersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<Offer> offers;

    public OffersAdapter(Context context, List<Offer> offers) {
        this.inflater = LayoutInflater.from(context);
        this.offers = offers;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OfferVH(inflater.inflate(R.layout.item_offer, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((OfferVH) holder).bind(offers.get(position));
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }
}
