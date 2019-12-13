package com.ryz2593.happy.study.thread.interview.A1B2C3;

/**
 *
 * @author ryz2593
 */
public class T02_00_sync_wait_notify {
    public static void main(String[] args) {
        final Object o = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(()->{
            synchronized (o) {
                for (char c : aI) {
                    System.out.println(c);

                    try {
                        o.notify();
                        //让出锁
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();//必须，否则无法停止程序
            }
        }, "t1").start();

        new Thread(()->{
            synchronized (o) {
                for (char c : aC) {
                    System.out.println(c);

                    try {
                        o.notify();
                        //让出锁
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();//必须，否则无法停止程序
            }
        }, "t2").start();
    }
}
