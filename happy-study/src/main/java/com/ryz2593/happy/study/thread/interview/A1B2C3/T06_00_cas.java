package com.ryz2593.happy.study.thread.interview.A1B2C3;

/**
 * 使用自旋锁式解法
 * 自旋锁：线程不会释放cpu，原地打转，可能会浪费cpu资源
 * 主要应用在代码执行速度特别快，执行时间特别短，自旋锁不涉及用户态和内核态的切换，只会在用户态中
 * 如果并发量很大，适不适合用自旋锁的，可以使用重量级锁synchronized
 * @author ryz2593
 */
public class T06_00_cas {
    enum ReadyToRun{T1, T2}
    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(()->{
            for (char c : aI) {
                while (r != ReadyToRun.T1){}
                System.out.println(c);
                r = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(()->{
            for (char c : aC) {
                while (r != ReadyToRun.T2){}
                System.out.println(c);
                r = ReadyToRun.T1;
            }
        }, "t2").start();
    }
}
