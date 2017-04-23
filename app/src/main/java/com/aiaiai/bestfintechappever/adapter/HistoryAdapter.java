package com.aiaiai.bestfintechappever.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.data.history.HistoryItem;
import com.aiaiai.bestfintechappever.model.vh.OnItemClickListener;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private final LayoutInflater layoutInflater;
    private final List<HistoryItem> historyItemList;
    private final OnItemClickListener onItemClickListener;

    public HistoryAdapter(Context context, List<HistoryItem> historyItemList, OnItemClickListener onItemClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.historyItemList = historyItemList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryViewHolder(layoutInflater.inflate(R.layout.item_history, parent, false), onItemClickListener);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        holder.bind(historyItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return historyItemList.size();
    }

    static class HistoryViewHolder extends ViewHolder {

        private TextView historyTitle;
        private TextView historyDate;
        private View historyButton;

        private final OnItemClickListener onItemClickListener;

        public HistoryViewHolder(View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            historyTitle = (TextView) itemView.findViewById(R.id.history_title);
            historyDate = (TextView) itemView.findViewById(R.id.history_date);
            historyButton = itemView.findViewById(R.id.history_button);
            historyButton.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     onItemClickListener.click(getAdapterPosition());
                                                 }
                                             }
            );
        }

        public void bind(HistoryItem historyItem) {
            historyTitle.setText(historyItem.getOffer().getDescription() + " Пин-код: " + historyItem.getCoupon());
            historyDate.setText(historyItem.getTimestamp());
        }
    }
}
