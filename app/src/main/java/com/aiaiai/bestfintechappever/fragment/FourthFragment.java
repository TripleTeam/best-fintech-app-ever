package com.aiaiai.bestfintechappever.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aiaiai.bestfintechappever.R;

/**
 * Created by Slavik on 23.04.2017.
 * Yippie-Kai-Yay!
 */

public class FourthFragment extends Fragment {

    private View rootView;

    public static FourthFragment instance() {
        return new FourthFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fourth, container, false);
        return rootView;
    }
}
