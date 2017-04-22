package com.aiaiai.bestfintechappever.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.adapter.OffersAdapter;
import com.aiaiai.bestfintechappever.model.Offer;
import com.aiaiai.bestfintechappever.util.itemdecoration.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class FirstFragment extends Fragment {

    private List<Offer> offers;

    private View rootView;
    private RecyclerView offersRecyclerView;

    public static FirstFragment instance() {
        return new FirstFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        offers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            offers.add(new Offer(i, "Offer " + i, "Description " + i,
                    "https://i.kinja-img.com/gawker-media/image/upload/t_original/bhjivrw2chm9um9yrrmy.jpg", "1"));
        }
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
        offersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        offersRecyclerView.setAdapter(new OffersAdapter(getContext(), offers));
        offersRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(8));
    }
}
