package com.aiaiai.bestfintechappever.data.mock;

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
                    "https://stepik.org/media/covers/asset-v1-PozdnyakovaSvetlana1000001typeassetblockfr_375_200_iBEbyaT.jpg",
                    20000 + i * 117 + "",
                    10000 + i * 113 + ""
            );
        }
    }
}
