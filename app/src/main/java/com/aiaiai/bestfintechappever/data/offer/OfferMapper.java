package com.aiaiai.bestfintechappever.data.offer;

import android.support.annotation.NonNull;

import com.aiaiai.bestfintechappever.model.Offer;

import java.util.ArrayList;
import java.util.List;

public class OfferMapper {

    private final String baseUrl;

    public OfferMapper(String baseUrl) {

        this.baseUrl = baseUrl;
    }

     public Offer toModel(NetworkOffer networkOffer) {

        long price = getNumber(networkOffer.getPrice());
        long discounted = getNumber(networkOffer.getDiscounted());
        long cashbackValue = price - discounted;

        Offer offer = new Offer(networkOffer.getId(),
                networkOffer.getDescription(),
                "",
                baseUrl + networkOffer.getImgUrl(),
                cashbackValue + "",
                price + "",
                networkOffer.getDiscount() //percent
        );
        return offer;
    }

    @NonNull
    public List<Offer> toModel(List<NetworkOffer> networkOffers) {
        List<Offer> result = new ArrayList<>(networkOffers.size());
        for (NetworkOffer networkOffer : networkOffers) {
            result.add(toModel(networkOffer));
        }
        return result;
    }

    private Long getNumber(String value) {
        String[] arr = value.split("\\.");
        String temp = arr[0].replaceAll("\\s+", "");
        long num = Long.parseLong(temp);
        return num;

    }
}
