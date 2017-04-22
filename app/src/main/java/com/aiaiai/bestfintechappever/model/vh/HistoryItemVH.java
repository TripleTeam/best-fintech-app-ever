package com.aiaiai.bestfintechappever.model.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.data.history.HistoryItem;

/**
 * Created by Slavik on 23.04.2017.
 * Yippie-Kai-Yay!
 */

public class HistoryItemVH extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView date;
    private Button button;

    public HistoryItemVH(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.history_title);
        date = (TextView) v.findViewById(R.id.history_date);
        button = (Button) v.findViewById(R.id.history_button);
    }

    public void bind(HistoryItem item) {
        title.setText(String.format("%s (Пин-код: %s)", item.getOffer().getDescription(), item.getCoupon()));
        date.setText(item.getTimestamp());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
