package com.ryz2593.happy.study.threadlocal;

/**
 * @author ryz2593
 * @date 2020/3/20 13:38
 */
public class ThreadLocalTest {

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    static class MyThread extends Thread {
        private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 3; i++) {
                threadLocal.set(i);
                System.out.println(getName() + " threadLocal.get() = " + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread myThreadA = new MyThread();
        myThreadA.setName("myThreadA");
        MyThread myThreadB = new MyThread();
        myThreadB.setName("myThreadB");
        myThreadA.start();
        myThreadB.start();
//        final ThreadLocalTest test = new ThreadLocalTest();
//
//        test.set();
//        System.out.println(test.getLong());
//        System.out.println(test.getString());
//
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                test.set();
//                System.out.println(test.getLong());
//                System.out.println(test.getString());
//            }
//
//            ;
//        };
//        thread1.start();
//        thread1.join();
//
//        System.out.println(test.getLong());
//        System.out.println(test.getString());
    }

}
