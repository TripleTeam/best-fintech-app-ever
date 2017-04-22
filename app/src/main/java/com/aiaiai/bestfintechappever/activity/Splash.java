package com.aiaiai.bestfintechappever.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aiaiai.bestfintechappever.R;

public class Splash extends AppCompatActivity {

    // TODO: 22.04.17 transfer to sp and check if access is granted
    final boolean isNotificationAccessIsReceived = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

//        if (!isNotificationAccessIsReceived) {
//            NotificationAccessRequester.requestNotification(this);
//        }
    }
}
