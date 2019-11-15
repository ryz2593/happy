package com.ryz2593.happy.study.producer_consumer.synchronized_wait_notify;

public class Producer implements Runnable {
    private Storage storage;

    public Producer() {
    }

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                storage.produce();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
