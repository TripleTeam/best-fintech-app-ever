package com.aiaiai.bestfintechappever.core.components;

import android.content.Context;

import com.aiaiai.bestfintechappever.core.modules.AppModule;
import com.aiaiai.bestfintechappever.fragment.FirstFragment;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {


    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }


    void inject(FirstFragment firstFragment);
}
