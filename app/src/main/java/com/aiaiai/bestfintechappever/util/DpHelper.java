package com.aiaiai.bestfintechappever.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by Slavik on 22.04.2017.
 * Yippie-Kai-Yay!
 */

public class DpHelper {

    public static int dpToPx(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return Math.round(dp * (metrics.densityDpi / 160f));
    }

}
