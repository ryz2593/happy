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
        private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };


        private int index;

        public MyThread(int index) {
            this.index = index;
        }


        @Override
        public void run() {
            super.run();
            System.out.println("线程" + index + "的初始value:" + threadLocal.get());
            for (int i = 0; i < 10; i++) {
                threadLocal.set(threadLocal.get() + i);
            }
            System.out.println("线程" + index + "的累加value:" + threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(i)).start();
        }

//        MyThread myThreadA = new MyThread();
//        myThreadA.setName("myThreadA");
//        MyThread myThreadB = new MyThread();
//        myThreadB.setName("myThreadB");
//        myThreadA.start();
//        myThreadB.start();

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