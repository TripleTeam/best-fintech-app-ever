package com.aiaiai.bestfintechappever.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.adapter.HistoryAdapter;
import com.aiaiai.bestfintechappever.core.App;
import com.aiaiai.bestfintechappever.data.cashback.CashbackRepository;
import com.aiaiai.bestfintechappever.data.history.HistoryItem;
import com.aiaiai.bestfintechappever.data.history.HistoryRepository;
import com.aiaiai.bestfintechappever.model.vh.OnItemClickListener;
import com.aiaiai.bestfintechappever.util.AppConstants;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class ThirdFragment extends Fragment implements HistoryRepository.Callback, CashbackRepository.Callback {

    private View rootView;

    public static ThirdFragment instance() {
        return new ThirdFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        App.component().inject(this);
    }

    private RecyclerView historyRecycler;
    private TextView thirdBablo;
    private TextView balance_second;
    private TextView balanceMonth;
    private TextView balance3Month;
    private TextView balanceYear;


    @Inject
    HistoryRepository historyRepository;

    @Inject
    CashbackRepository cashbackRepository;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_third, container, false);
        historyRecycler = (RecyclerView) rootView.findViewById(R.id.third_history);
        thirdBablo = (TextView) rootView.findViewById(R.id.third_bablo);
        balance_second = (TextView) rootView.findViewById(R.id.balance_second);
        balanceMonth = (TextView) rootView.findViewById(R.id.balanceMonth);
        balance3Month = (TextView) rootView.findViewById(R.id.balance3Month);
        balanceYear = (TextView) rootView.findViewById(R.id.balanceYear);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        historyRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
//        historyRecycler.addItemDecoration(new VerticalSpaceItemDecoration(8));
        historyRepository.getHistory(this);
        cashbackRepository.getCashback(this);
    }

    @Override
    public void showHistory(final List<HistoryItem> historyItemList) {
        Context context = getContext();

        if (context != null) {
            OnItemClickListener onItemClickListener = new OnItemClickListener() {
                @Override
                public void click(int position) {
                    HistoryItem historyItem = historyItemList.get(position);
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(AppConstants.baseUrl + historyItem.getPdfUrl()));
                    browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    App.getAppContext().startActivity(browserIntent);
                }
            };
            HistoryAdapter adapter = new HistoryAdapter(context, historyItemList, onItemClickListener);
            historyRecycler.setAdapter(adapter);
        }
    }

    @Override
    public void showError() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, "Интернет опять не работает", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showCashbackValue(long cashbackValue) {
        Context context = getContext();

        if (context != null) {
            thirdBablo.setText(cashbackValue + " руб.");
            balance_second.setText(cashbackValue + " руб.");

            balanceMonth.setText(String.format("%.2f", cashbackValue * 1.0058));
            balance3Month.setText(String.format("%.2f", cashbackValue * 1.0176));
            balanceYear.setText(String.format("%.2f", cashbackValue * 1.0723));


        }
    }

    @Override
    public void showCashbackError() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, "Интернет опять не работает", Toast.LENGTH_SHORT).show();
        }
    }
}
