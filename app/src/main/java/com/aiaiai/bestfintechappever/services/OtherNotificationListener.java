package com.aiaiai.bestfintechappever.services;

import android.app.Notification;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.annotation.WorkerThread;
import android.util.Log;
import android.widget.Toast;

import com.aiaiai.bestfintechappever.util.notification.NotificationFieldsNameProvider;

public class OtherNotificationListener extends NotificationListenerService {

    private final String TAG = "NotificationListener";

    @WorkerThread
    @Override
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        final String packageName = statusBarNotification.getPackageName();
        // TODO: 22.04.17 filter only apps of banks, that we support


        final Notification notification = statusBarNotification.getNotification();
        if (notification == null) {
            Log.d(TAG, "notification was null");
            return;
        }

        Bundle extras = notification.extras;
        if (extras == null) {
            Log.d(TAG, "extras of notification were null");
            return;
        }

        final String title = extras.getString(NotificationFieldsNameProvider.getTitleName());
        final String subText = extras.getString(NotificationFieldsNameProvider.getSubTextName());
        final String text = extras.getString(NotificationFieldsNameProvider.getTextName());
        final String bigText = extras.getString(NotificationFieldsNameProvider.getBigTextName());


        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        // Nothing to do
    }

}
