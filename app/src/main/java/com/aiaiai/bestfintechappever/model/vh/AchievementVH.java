package com.aiaiai.bestfintechappever.model.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.model.Achievement;

/**
 * Created by Slavik on 23.04.2017.
 * Yippie-Kai-Yay!
 */

public class AchievementVH extends RecyclerView.ViewHolder {

    private TextView text;
    private TextView status;
    private ProgressBar progress;

    public AchievementVH(View v) {
        super(v);
        text = (TextView) v.findViewById(R.id.achivka_text);
        status = (TextView) v.findViewById(R.id.achivka_status);
        progress = (ProgressBar) v.findViewById(R.id.achivka_progress);
    }

    public void bind(Achievement achievement) {

    }
}
