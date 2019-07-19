package com.ryz2593.happy;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //创建连接池
        final DataSourcePool dataSourcePool = new DataSourcePoolImpl();

        for (int i = 0; i < 20; i++) {
            new Thread() {
                @Override
                public void run() {
                    PooledConnection dataSource = dataSourcePool.getDataSource();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dataSource.releaseConnection();
                }
            }.start();
        }
    }
}
