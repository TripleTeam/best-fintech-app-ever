package com.aiaiai.bestfintechappever.core.modules;

import com.aiaiai.bestfintechappever.data.ApiRetrofitService;
import com.aiaiai.bestfintechappever.data.letty_offer.LetyOfferRepository;
import com.aiaiai.bestfintechappever.data.letty_offer.mock.LetyMockOfferRepository;
import com.aiaiai.bestfintechappever.data.offer.NetworkOfferRepository;
import com.aiaiai.bestfintechappever.data.offer.OfferApi;
import com.aiaiai.bestfintechappever.data.offer.OfferApiImpl;
import com.aiaiai.bestfintechappever.data.offer.OfferMapper;
import com.aiaiai.bestfintechappever.data.offer.OfferRepository;
import com.aiaiai.bestfintechappever.util.AppConstants;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class AppModule {

    @Binds
    @Singleton
    abstract OfferRepository bindOfferRepository(NetworkOfferRepository repository);

    @Binds
    @Singleton
    abstract LetyOfferRepository bindLettyOfferRepository(LetyMockOfferRepository repository);

    @Binds
    @Singleton
    abstract OfferApi bindOfferApi(OfferApiImpl offerApi);

    @Provides
    @Singleton
    static String provideBaseUrl() {
        return AppConstants.baseUrl;
    }

    @Provides
    @Singleton
    static ApiRetrofitService provideRetrofitService(String baseUrl) {
        GsonConverterFactory factory = GsonConverterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(factory)
                .build();

        return retrofit.create(ApiRetrofitService.class);
    }

    @Provides
    @Singleton
    static OfferMapper provideOfferMapper(String baseUrl) {
        return new OfferMapper(baseUrl);
    }

}
