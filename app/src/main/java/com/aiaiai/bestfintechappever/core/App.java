package com.aiaiai.bestfintechappever.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.aiaiai.bestfintechappever.core.components.AppComponent;
import com.aiaiai.bestfintechappever.core.components.DaggerAppComponent;

public class App extends Application {
    //here we can init something for dagger/utils/etc

    private AppComponent component;
    private static App app;

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

        initApplication();
        initDI();
    }

    private void initApplication() {
        app = this;
    }

    private void initDI() {

        component = DaggerAppComponent.builder()
                .context(app)
                .build();

    }

    public static Context getAppContext() {
        return app.getApplicationContext();
    }

    public static AppComponent component() {
        return app.component;
    }

}
