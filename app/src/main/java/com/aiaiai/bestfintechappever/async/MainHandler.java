package com.aiaiai.bestfintechappever.async;

public interface MainHandler {

    interface OnMainThread {
        void doOnMain();
    }

    void post(OnMainThread onMainThread);
}
