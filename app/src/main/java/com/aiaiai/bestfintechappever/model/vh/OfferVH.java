package com.aiaiai.bestfintechappever.model.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiaiai.bestfintechappever.model.Offer;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class OfferVH extends RecyclerView.ViewHolder {

    private ImageView pic;
    private TextView title;
    private TextView description;
    private TextView price;

    public OfferVH(View v) {
        super(v);
//        pic = (ImageView) v.findViewById(R.id.);
//        title = (TextView) v.findViewById(R.id.);
//        description = (TextView) v.findViewById(R.id.);
//        price = (TextView) v.findViewById(R.id.);
    }

    public void bind(Offer offer) {

    }
}
