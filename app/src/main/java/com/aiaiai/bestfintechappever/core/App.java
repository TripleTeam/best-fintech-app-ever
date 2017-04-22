package com.aiaiai.bestfintechappever.core;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class App extends Application {
    //here we can init something for dagger/utils/etc
    @Override
    public void onCreate() {
        super.onCreate();

        //set portrait orientation for app
        registerActivityLifecycleCallbacks(new ActivityLifecycleStub() {
            @Override
            public void onActivityCreated(Activity a, Bundle savedInstanceState) {
                a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });
    }

}
