package com.aiaiai.bestfintechappever.data.letty_offer.mock;

import com.aiaiai.bestfintechappever.data.letty_offer.LetyOfferRepository;
import com.aiaiai.bestfintechappever.model.LetyShopsOffer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class LetyMockOfferRepository implements LetyOfferRepository {

    @Inject
    LetyMockOfferRepository() {

    }

    @Override
    public void prepareOffers(LetyOfferRepository.Callback callback) {
        List<LetyShopsOffer> offerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            LetyShopsOffer offer = new LetyShopsOffer(
                    i,
                    "Aliexpress",
                    "5%",
                    "https://image01.letyshops.ru/sites/default/files/styles/shop_logo_143x59/public/aliexpress1.jpg?itok=v6nZhFkg"
            );
            offerList.add(offer);
        }
        callback.onLettyOfferPrepared(offerList);
    }
}
