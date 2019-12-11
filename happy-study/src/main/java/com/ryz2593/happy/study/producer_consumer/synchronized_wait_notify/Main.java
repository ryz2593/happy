package com.ryz2593.happy.study.producer_consumer.synchronized_wait_notify;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread p1 = new Thread(new Producer(storage));
        Thread p2 = new Thread(new Producer(storage));
        Thread p3 = new Thread(new Producer(storage));

        Thread c1 = new Thread(new Consumer(storage));
        Thread c2 = new Thread(new Consumer(storage));
        Thread c3 = new Thread(new Consumer(storage));

//        ExecutorService executorService = new ThreadPoolExecutor(3, 3,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                new Producer(storage).run();
//            }
//        });
//        ExecutorService executorService2 = new ThreadPoolExecutor(3, 3,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
//        executorService2.execute(new Runnable() {
//            @Override
//            public void run() {
//                new Consumer(storage).run();
//            }
//        });

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
