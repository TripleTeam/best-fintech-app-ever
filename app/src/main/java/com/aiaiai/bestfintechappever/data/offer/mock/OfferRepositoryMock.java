package com.aiaiai.bestfintechappever.data.offer.mock;

import com.aiaiai.bestfintechappever.data.OfferRepository;
import com.aiaiai.bestfintechappever.model.Offer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class OfferRepositoryMock implements OfferRepository {
    @Inject
    OfferRepositoryMock() {

    }


    @Override
    public void prepareOffers(Callback callback) {
        List<Offer> offerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Offer offer = new Offer(
                    i,
                    "Заголовок #" + i + ". ",
                    "Это просто лучший товар #" + i + ". Его очень длинное описание. Его очень длинное описание. Его очень длинное описание. Его очень длинное описание. Его очень длинное описание. Его очень длинное описание. Его очень длинное описание. ",
                    "http://st.biglion.ru/c/w/672/h/378/cfs15/deal_offer/55/43/55430fd0888e46f90f34f5b0b6ba73c4.jpg",
                    20000 + i * 117 + "",
                    10000 + i * 113 + ""
            );
            offerList.add(offer);
        }
        callback.onOfferPrepared(offerList);
    }
}
