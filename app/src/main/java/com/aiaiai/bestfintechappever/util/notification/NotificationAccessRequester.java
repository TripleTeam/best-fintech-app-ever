package com.aiaiai.bestfintechappever.util.notification;

import android.content.Context;
import android.content.Intent;

public class NotificationAccessRequester {

    public static void requestNotification(Context context) {
        context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

}
