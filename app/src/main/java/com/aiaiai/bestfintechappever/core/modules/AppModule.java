package com.aiaiai.bestfintechappever.core.modules;

import com.aiaiai.bestfintechappever.data.OfferRepository;
import com.aiaiai.bestfintechappever.data.mock.OfferRepositoryMock;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppModule {

    @Binds
    abstract OfferRepository bindOfferRepository(OfferRepositoryMock mock);
}
