package com.aiaiai.bestfintechappever.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.adapter.OffersAdapter;
import com.aiaiai.bestfintechappever.core.App;
import com.aiaiai.bestfintechappever.data.BuyerManager;
import com.aiaiai.bestfintechappever.data.offer.OfferRepository;
import com.aiaiai.bestfintechappever.model.Offer;
import com.aiaiai.bestfintechappever.model.vh.OnItemClickListener;
import com.aiaiai.bestfintechappever.util.itemdecoration.VerticalSpaceItemDecoration;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class FirstFragment extends Fragment implements OfferRepository.Callback, BuyerManager.Callback {

    private View rootView;
    protected RecyclerView offersRecyclerView;

    public static FirstFragment instance() {
        return new FirstFragment();
    }

    @Inject
    OfferRepository offerRepository;

    @Inject
    BuyerManager buyerManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        injectDependencies();
    }

    protected void injectDependencies() {
        App.component().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_first, container, false);
        offersRecyclerView = (RecyclerView) rootView.findViewById(R.id.first_offers_rv);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        offersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        offersRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(8));
        initiateLoading();
    }

    public void initiateLoading() {
        offerRepository.prepareOffers(this);
    }

    boolean isBuying = false;

    @Override
    public void onOfferPrepared(final List<Offer> offerList) {
        Context context = getContext();
        if (offersRecyclerView != null && context != null) {
            OnItemClickListener onItemClickListener = new OnItemClickListener() {
                @Override
                public void click(int position) {
                    if (!isBuying) {
                        isBuying = true;
                        Offer offer = offerList.get(position);
                        buyerManager.postBuying(offer.getId(), FirstFragment.this);
                    }
                }
            };
            OffersAdapter adapter = new OffersAdapter(context, offerList, onItemClickListener);
            offersRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onError() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, "Интернет опять не работает", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBought() {
        isBuying = false;
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, "Успешно куплено, показать поп ап", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onErrorBought() {
        isBuying = false;
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, "что-то пошло не так", Toast.LENGTH_SHORT).show();
        }

    }
}
