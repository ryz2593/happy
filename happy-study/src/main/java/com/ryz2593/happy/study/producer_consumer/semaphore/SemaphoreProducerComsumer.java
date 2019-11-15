package com.ryz2593.happy.study.producer_consumer.semaphore;

public class SemaphoreProducerComsumer {
    public static void main(String[] args) {
        final Buffer buffer = new Buffer();
        startProducer(buffer);
        startProducer(buffer);
        startConsumer(buffer);
        startConsumer(buffer);
    }

    public static void startProducer(final Buffer buffer) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        buffer.put();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void startConsumer(final Buffer buffer) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        buffer.get();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
