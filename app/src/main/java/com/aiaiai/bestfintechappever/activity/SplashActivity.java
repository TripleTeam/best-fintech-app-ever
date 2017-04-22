package com.aiaiai.bestfintechappever.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.aiaiai.bestfintechappever.core.App;
import com.aiaiai.bestfintechappever.data.letty_offer.LetyOfferRepository;
import com.aiaiai.bestfintechappever.data.offer.OfferRepository;
import com.aiaiai.bestfintechappever.model.LetyShopsOffer;
import com.aiaiai.bestfintechappever.model.Offer;

import java.util.List;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 500;

    @Inject
    OfferRepository offerRepository;

    @Inject
    LetyOfferRepository letyOfferRepository;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This stops from opening again from the Splash screen when minimized
        if (!isTaskRoot()) {
            finish();
            return;
        }

        App.component().inject(this);

        letyOfferRepository.prepareOffers(new LetyOfferRepository.Callback() {
            @Override
            public void onLettyOfferPrepared(@NonNull List<LetyShopsOffer> offerList) {
                count++;
                if (count > 1) {
                    openMainScreen();
                }
            }

            @Override
            public void onError() {
                openMainScreen();
            }
        });

        offerRepository.prepareOffers(new OfferRepository.Callback() {
            @Override
            public void onOfferPrepared(@NonNull List<Offer> offerList) {
                count++;
                if (count > 1) {
                    openMainScreen();
                }
            }

            @Override
            public void onError() {
                openMainScreen();
            }
        });

    }

    private void openMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
