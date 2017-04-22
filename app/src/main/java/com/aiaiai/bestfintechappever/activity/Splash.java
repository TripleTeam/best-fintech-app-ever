package com.aiaiai.bestfintechappever.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.util.notification.NotificationAccessRequester;

public class Splash extends AppCompatActivity {

    // TODO: 22.04.17 transfer to sp and check if access is granted
    final boolean isNotificationAccessIsReceived = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (!isNotificationAccessIsReceived) {
            NotificationAccessRequester.requestNotification(this);
        }
    }
}
