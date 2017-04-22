package com.aiaiai.bestfintechappever.model.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.model.OfferLetyShops;
import com.bumptech.glide.Glide;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class OfferLetyShopsVH extends RecyclerView.ViewHolder {

    private ImageView pic;
    private TextView title;
    private TextView cashback;
    private TextView percent;
    private Button button;

    public OfferLetyShopsVH(View v) {
        super(v);
        pic = (ImageView) v.findViewById(R.id.offer_pic);
        title = (TextView) v.findViewById(R.id.offer_title);
        cashback = (TextView) v.findViewById(R.id.offer_cashback);
        percent = (TextView) v.findViewById(R.id.offer_percent);
        button = (Button) v.findViewById(R.id.offer_button);
    }

    public void bind(OfferLetyShops offer) {
        Glide.with(pic.getContext())
                .load(offer.getPicUrl())
                .centerCrop()
                .into(pic);
        title.setText(offer.getTitle());
        cashback.setText(String.format("Кэшбэк: %s%", offer.getCashback()));
        percent.setText(offer.getCashback());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
