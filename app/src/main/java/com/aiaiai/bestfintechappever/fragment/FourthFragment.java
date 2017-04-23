package com.aiaiai.bestfintechappever.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.core.App;
import com.aiaiai.bestfintechappever.data.gifts.GiftPoster;
import com.aiaiai.bestfintechappever.model.Offer;
import com.aiaiai.bestfintechappever.model.vh.CutOfferVh;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;

import javax.inject.Inject;

/**
 * Created by Slavik on 23.04.2017.
 * Yippie-Kai-Yay!
 */

public class FourthFragment extends Fragment implements GiftPoster.Callback {

    private View rootView;

    public static FourthFragment instance() {
        return new FourthFragment();
    }

    @Inject
    GiftPoster giftPoster;

    private Button offerButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        App.component().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fourth, container, false);
        offerButton = (Button) rootView.findViewById(R.id.offer_button);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        offerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offerButton.setEnabled(false);
                giftPoster.requestGift(FourthFragment.this);
            }
        });
    }

    @Override
    public void showGift(Offer offer) {
        // FIXME: 23.04.17 SHOW POPUP

        Context context = getContext();
        if (context != null) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_offer_cut, null);
            CutOfferVh offerVH = new CutOfferVh(view);
            offerVH.bind(offer);

            new MaterialStyledDialog.Builder(context)
                    .setTitle("Вы выиграли!")
                    .setStyle(Style.HEADER_WITH_TITLE)
                    .setCustomView(view)
                    .setScrollable(true)
                    .setPositiveText("Ок")
                    .show();

            offerButton.setEnabled(true);
        }
    }

    @Override
    public void notEnoughMoney() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, "Недостаточно средств, покупайте с кэшбеком", Toast.LENGTH_SHORT).show();
            offerButton.setEnabled(true);
        }
    }

    @Override
    public void onInternetError() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, "Интернет опять не работает", Toast.LENGTH_SHORT).show();
            offerButton.setEnabled(true);
        }
    }
}
