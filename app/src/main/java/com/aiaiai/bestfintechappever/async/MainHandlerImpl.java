package com.aiaiai.bestfintechappever.async;

import android.content.Context;
import android.os.Handler;

import javax.inject.Inject;

public class MainHandlerImpl implements MainHandler {

    private final Context context;
    Handler mainHandler;

    @Inject
    public MainHandlerImpl(Context context) {
        this.context = context;
        mainHandler = new Handler(context.getMainLooper());
    }

    @Override
    public void post(final OnMainThread onMainThread) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                onMainThread.doOnMain();
            }
        });
    }


}
