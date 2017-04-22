package com.aiaiai.bestfintechappever.core.modules;

import com.aiaiai.bestfintechappever.data.OfferRepository;
import com.aiaiai.bestfintechappever.data.offer.mock.OfferRepositoryMock;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppModule {

    @Binds
    @Singleton
    abstract OfferRepository bindOfferRepository(OfferRepositoryMock mock);
}
