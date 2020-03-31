package com.ryz2593.happy.study.threadlocal;

/**
 * ThreadLocal 中存储的是线程本地的变量，线程之间是隔离的
 * 如果是使用了线程池，在threadLocal中设置了变量的值，
 * 在使用之后最好进行清除，否则当前任务结束了线程被释放回到了线程池中并没有被销毁
 * 线程被一个任务使用了，使用到这个变量，
 * @author ryz2593
 * @date 2020/3/20 13:38
 */
public class ThreadLocalTest {
    //创建一个全局的integerLocal变量
    static ThreadLocal<Integer> integerLocal = new ThreadLocal<>();
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

//        for (int i = 0; i < 5; i++) {
//            new Thread(new MyThread(i)).start();
//        }

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


        Thread t1 = new Thread(()->{
            System.out.println(integerLocal.get());
            integerLocal.set(0);
            System.out.println(integerLocal.get());
        });

        Thread t2 = new Thread(()->{
            System.out.println(integerLocal.get());
            integerLocal.set(1);
            System.out.println(integerLocal.get());
        });

        t1.start();

        //线程1执行完在执行线程2 join()的作用 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
        //t.join();      //调用join方法，等待线程t执行完毕
        t1.join();

        t2.start();


    }

}
