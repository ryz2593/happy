package com.ryz2593.happy.study.producer_consumer.lock_await_signal;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ryz2593
 */
public class Storage {
    private final int MAX_SIZE = 10;

    private LinkedList<Object> list = Lists.newLinkedList();

    private final Lock lock = new ReentrantLock();

    private final Condition full = lock.newCondition();

    private final Condition empty = lock.newCondition();

    public void produce() {
        lock.lock();
        while (list.size() + 1 > MAX_SIZE) {
            System.out.println("【生产者" + Thread.currentThread().getName() + "】仓库已满");
            try {
                full.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(new Object());
        System.out.println("【生产者" + Thread.currentThread().getName() + "】生产一个产品，现库存" + list.size());
        empty.signalAll();
        lock.unlock();
    }

    public void consumer() {
        lock.lock();
        while (list.size() == 0) {
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】仓库为空");
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove();
        System.out.println("【消费者" + Thread.currentThread().getName()
                + "】消费一个产品，现库存" + list.size());
        full.signalAll();
        lock.unlock();
    }
}
