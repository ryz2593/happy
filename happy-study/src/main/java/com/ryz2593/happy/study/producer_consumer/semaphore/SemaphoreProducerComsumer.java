package com.ryz2593.happy.study.producer_consumer.semaphore;

public class SemaphoreProducerComsumer {
    public static void main(String[] args) {
        final Storage storage = new Storage();
        startProducer(storage);
        startProducer(storage);
        startConsumer(storage);
        startConsumer(storage);
    }

    public static void startProducer(final Storage storage) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        storage.put();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void startConsumer(final Storage storage) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        storage.get();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
