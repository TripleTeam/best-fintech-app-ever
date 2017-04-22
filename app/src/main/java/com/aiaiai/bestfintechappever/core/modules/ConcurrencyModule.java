package com.aiaiai.bestfintechappever.core.modules;

import com.aiaiai.bestfintechappever.async.MainHandler;
import com.aiaiai.bestfintechappever.async.MainHandlerImpl;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ConcurrencyModule {

    @Binds
    @Singleton
    abstract MainHandler bindMainHandler(MainHandlerImpl mainHandler);

    @Provides
    @Singleton
    static ThreadPoolExecutor provideThreadPoolExecutor() {
        return (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }
}
