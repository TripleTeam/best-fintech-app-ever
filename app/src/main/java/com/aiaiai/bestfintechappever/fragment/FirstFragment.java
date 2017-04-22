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
import com.aiaiai.bestfintechappever.data.OfferRepository;
import com.aiaiai.bestfintechappever.model.Offer;
import com.aiaiai.bestfintechappever.util.itemdecoration.VerticalSpaceItemDecoration;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class FirstFragment extends Fragment implements OfferRepository.Callback {

    private View rootView;
    private RecyclerView offersRecyclerView;
    private OffersAdapter adapter;

    public static FirstFragment instance() {
        return new FirstFragment();
    }

    @Inject
    OfferRepository offerRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
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
        offerRepository.prepareOffers(this);
    }

    @Override
    public void onOfferPrepared(List<Offer> offerList) {
        if (offersRecyclerView != null) {
            adapter = new OffersAdapter(getContext(), offerList);
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
}
