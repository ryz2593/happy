package com.ryz2593.happy.study.producer_consumer.synchronized_wait_notify;

public class Consumer implements Runnable {
    private Storage storage;

    public Consumer() {
    }

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                storage.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
