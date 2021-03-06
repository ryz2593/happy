package com.ryz2593.happy.study.producer_consumer.synchronized_wait_notify;

import com.google.common.collect.Lists;
import java.util.LinkedList;
/**
 * @author ryz2593
 */
public class Storage {
    /**
     * 仓库容量
     */
    private final int MAX_SIZE = 10;

    /**
     * 仓库存储的载体
     */
    private LinkedList<Object> list = Lists.newLinkedList();

    public void produce() {
        synchronized (list) {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("[producer" + Thread.currentThread().getName()
                        + "] storage is full");
                try {
                        list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("[Consumer" + Thread.currentThread().getName()
                    + "]生产一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }

    public void consumer() {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("[Consumer" + Thread.currentThread().getName()
                        + "] storage is empty");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("[Consumer" + Thread.currentThread().getName()
                    + "]消费一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }
}
