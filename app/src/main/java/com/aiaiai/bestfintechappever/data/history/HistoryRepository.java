package com.aiaiai.bestfintechappever.data.history;

import com.aiaiai.bestfintechappever.async.MainHandler;
import com.aiaiai.bestfintechappever.data.ApiRetrofitService;
import com.aiaiai.bestfintechappever.util.AppConstants;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HistoryRepository {
    private final ThreadPoolExecutor threadPoolExecutor;
    private final MainHandler mainHandler;
    private final ApiRetrofitService apiRetrofitService;

    @Inject
    public HistoryRepository(ThreadPoolExecutor threadPoolExecutor, MainHandler mainHandler, ApiRetrofitService apiRetrofitService) {

        this.threadPoolExecutor = threadPoolExecutor;
        this.mainHandler = mainHandler;
        this.apiRetrofitService = apiRetrofitService;
    }


    public void getHistory(final Callback callback) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final List<HistoryItem> historyItems = apiRetrofitService.getHistory(AppConstants.userId).execute().body();
                    mainHandler.post(new MainHandler.OnMainThread() {
                        @Override
                        public void doOnMain() {
                            callback.showHistory(historyItems);
                        }
                    });
                } catch (Exception e) {
                    mainHandler.post(new MainHandler.OnMainThread() {
                        @Override
                        public void doOnMain() {
                            callback.showError();
                        }
                    });
                }

            }
        });
    }

    public interface Callback {
        void showHistory(List<HistoryItem> historyItemList);

        void showError();
    }

}
