package com.ryz2593.happy.study.thread;

/**
 *
 * 这里，threadOb 是一个实现 Runnable 接口的类的实例，并且 threadName 指定新线程的名字。
 *
 * 新线程创建之后，你调用它的 start() 方法它才会运行
 * 
 * @autor ryz2593
 * @date 2019/11/17 21:11
 * @desc
 */
public class RunnableDemo implements Runnable {

    private Thread t;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating = " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running = " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");

    }

    public void start() {
        System.out.println("Starting = " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();

        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();
    }
}
