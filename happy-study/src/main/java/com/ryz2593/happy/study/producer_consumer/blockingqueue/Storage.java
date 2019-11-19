package com.ryz2593.happy.study.producer_consumer.blockingqueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ryz2593
 */
public class Storage {
    /**
     * 仓库存储的载体
     */
    private LinkedBlockingDeque<Object> list = new LinkedBlockingDeque<>(10);

    public void producer() {
        try {
            list.put(new Object());
            System.out.println("[Producer" + Thread.currentThread().getName()
                    + "]生产一个产品，现库存" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consumer() {
        try {
            list.take();
            System.out.println("[Consumer" + Thread.currentThread().getName()
                    + "]消费了一个产品，现库存" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
