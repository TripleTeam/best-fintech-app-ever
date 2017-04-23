package com.aiaiai.bestfintechappever.model.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.model.Offer;
import com.bumptech.glide.Glide;

public class CutOfferVh extends RecyclerView.ViewHolder {


    private ImageView pic;
    private TextView title;
    private TextView price;

    public CutOfferVh(View v) {
        super(v);
        pic = (ImageView) v.findViewById(R.id.offer_pic);
        title = (TextView) v.findViewById(R.id.offer_title);
        price = (TextView) v.findViewById(R.id.offer_price);
    }

    public void bind(Offer offer) {
        Glide.with(pic.getContext())
                .load(offer.getPicUrl())
                .centerCrop()
                .into(pic);
        title.setText(offer.getTitle());
        price.setText(String.format("Стоимость: %s руб.", offer.getPrice()));
    }
}
