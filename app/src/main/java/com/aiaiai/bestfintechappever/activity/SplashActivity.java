package com.aiaiai.bestfintechappever.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.aiaiai.bestfintechappever.util.notification.NotificationAccessRequester;

public class SplashActivity extends AppCompatActivity {

    // TODO: 22.04.17 transfer to sp and check if access is granted
    //We need to request notification for each change in binary code
    final boolean isNotificationAccessIsReceived = true;
    private static final int SPLASH_TIME_OUT = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This stops from opening again from the Splash screen when minimized
        if (!isTaskRoot()) {
            finish();
            return;
        }

        openMainScreen();
    }

    private void openMainScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private void requestNotificationPermission() {
        if (!isNotificationAccessIsReceived) {
            NotificationAccessRequester.requestNotification(this);
        }
    }
}
