package com.aiaiai.bestfintechappever.data.cashback;

import com.aiaiai.bestfintechappever.async.MainHandler;
import com.aiaiai.bestfintechappever.data.ApiRetrofitService;
import com.aiaiai.bestfintechappever.util.AppConstants;

import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CashbackRepository {

    private final ThreadPoolExecutor threadPoolExecutor;
    private final MainHandler mainHandler;
    private final ApiRetrofitService apiRetrofitService;

    @Inject
    public CashbackRepository(ThreadPoolExecutor threadPoolExecutor, MainHandler mainHandler, ApiRetrofitService apiRetrofitService) {
        this.threadPoolExecutor = threadPoolExecutor;
        this.mainHandler = mainHandler;
        this.apiRetrofitService = apiRetrofitService;
    }


    public void getCashback(final Callback callback) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final long cashbackValue = apiRetrofitService.getCashBack(AppConstants.userId).execute().body().getValue();
                    mainHandler.post(new MainHandler.OnMainThread() {
                        @Override
                        public void doOnMain() {
                            callback.showCashbackValue(cashbackValue);
                        }
                    });
                } catch (Exception e) {
                    mainHandler.post(new MainHandler.OnMainThread() {
                        @Override
                        public void doOnMain() {
                            callback.showCashbackError();
                        }
                    });
                }

            }
        });
    }

    public interface Callback {
        void showCashbackValue(long cashbackValue);

        void showCashbackError();
    }
}
