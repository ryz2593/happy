package com.ryz2593.happy.study.threadlocal;

/**
 *需求：线程隔离
 * 在多线程并发场景下，每个线程中的变量都是独立的
 * 线程A：设置（变量1） 获取（变量1）
 * 线程B：设置（变量2） 获取（变量2）
 *
 * java中的线程调度是抢占式调度，碰巧情况下会返回正常结果，但是一定会出现线程之间错误调取数据的现象
 *
 *  使用synchronized关键字同样可以解决这个问题， 但是会造成性能下降，
 *  因为使用synchronized关键字括起来的代码线程只能排队进行访问，这样会让程序失去了并发性
 *
 *          ThreadLocal 和 synchronized的区别
 *  原理：   synchronized：同步机制采用以时间换空间的方式，只提供一份变量让不同的线程排队访问
 *          ThreadLocal: 采用以空间换时间的方式，为每一个线程都提供了一份变量的副本，从而实现同时访问而互不干扰
 *  侧重点：  synchronized: 多个线程之间访问资源的同步
 *          ThreadLocal：多线程中让多个线程之间的数据互相隔离
 *
 *
 *
 * @author ryz2593
 * @date 2020/3/31 15:52
 */
public class MyDemo02 {
    //变量
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        MyDemo02 demo = new MyDemo02();
        for (int i = 0; i< 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    /**
                     * 每个线程存一个变量，过一会 取出这个变量
                     */
                    synchronized (MyDemo02.class) {
                        demo.setContent(Thread.currentThread().getName()+ "的数据");
                        System.out.println("------------------------");
                        System.out.println(Thread.currentThread().getName()+"--->"+demo.getContent());
                    }
                }
            });
            thread.setName("thread" + i);
            thread.start();
        }
    }
}
