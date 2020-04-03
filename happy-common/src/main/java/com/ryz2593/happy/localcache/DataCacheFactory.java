package com.ryz2593.happy.localcache;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class DataCacheFactory {

    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

    public static <T> DataCache<T> newExpiredDataCache(DataCacheLoader<T> cacheDataLoader, Long expired) {
        return new ExpiredDataCache(cacheDataLoader, expired);
    }

    public static <T> DataCache<T> newReadOldOnExpiredDataCache(DataCacheLoader<T> cacheDataLoader, Long expired) {
        return new ReadOldOnExpiredDataCache(cacheDataLoader, expired);
    }

    public static <T> DataCache<T> newScheduledDataCache(DataCacheLoader cacheDataLoader, Long expired, Long interval) {
        return new ScheduledDataCache<T>(cacheDataLoader, expired, interval);
    }

    private abstract static class AbstractDataCache<T> implements DataCache {
        protected volatile T data;
        protected Long expired;//millisecond
        protected DataCacheLoader<T> cacheDataLoader;
        protected Long lastModified;

        public AbstractDataCache(DataCacheLoader<T> cacheDataLoader, Long expired) {
            this(cacheDataLoader, expired, true);
        }

        public AbstractDataCache(DataCacheLoader<T> cacheDataLoader, Long expired, boolean isInit) {
            this.cacheDataLoader = cacheDataLoader;
            this.expired = expired;
            if (isInit) {
                this.reload();
            }

        }


        @Override
        public void reload() {
            lastModified = System.currentTimeMillis();
            data = cacheDataLoader.loadData();
        }

        @Override
        public void remove() {
            lastModified = System.currentTimeMillis();
            data = null;
        }

        public boolean isExpired() {
            return (lastModified == null) || (lastModified + expired) < System.currentTimeMillis();
        }
    }

    private static class ExpiredDataCache<T> extends AbstractDataCache<T> implements DataCache {


        public ExpiredDataCache(DataCacheLoader<T> cacheDataLoader, Long expired) {
            super(cacheDataLoader, expired);
        }

        public ExpiredDataCache(DataCacheLoader<T> cacheDataLoader, Long expired, boolean isInit) {
            super(cacheDataLoader, expired, isInit);
        }

        @Override
        public T getData() {
            if (data == null || isExpired()) {
                synchronized (this) {
                    if (data == null || isExpired()) {
                        reload();
                    }
                }
            }
            return data;
        }


    }

    private static class ReadOldOnExpiredDataCache<T> extends ExpiredDataCache<T> implements DataCache {

        private ReentrantLock reentrantLock = new ReentrantLock();

        public ReadOldOnExpiredDataCache(DataCacheLoader<T> cacheDataLoader, Long expired) {
            super(cacheDataLoader, expired);
        }

        @Override
        public T getData() {
            if (data == null) {
                return super.getData();
            } else if (isExpired()) {
                boolean lock = reentrantLock.tryLock();
                if (lock) {
                    try {
                        reload();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
            return data;
        }
    }

    private static class ScheduledDataCache<T> extends ExpiredDataCache<T> implements DataCache {

        public ScheduledDataCache(DataCacheLoader<T> cacheDataLoader, Long expired, Long interval) {
            super(cacheDataLoader, expired, false);
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    reload();

                }
            }, 0, interval, TimeUnit.MILLISECONDS);
        }

        @Override
        public T getData() {
            if (data == null) {
                return super.getData();
            }
            return data;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DataCache<String> dataCache = DataCacheFactory.newScheduledDataCache(new DataCacheLoader<String>() {
            @Override
            public String loadData() {

                Long t=System.currentTimeMillis();
                System.out.println(t+"  "+  new Date());
                return t + "";
            }
        }, 5000L, 3000L);

        for (int i = 0; i < 200; i++) {
            Thread.sleep(2000L);
            System.out.println("data=" + dataCache.getData());

        }

    }
}
