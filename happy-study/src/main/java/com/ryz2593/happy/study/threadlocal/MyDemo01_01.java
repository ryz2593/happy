package com.ryz2593.happy.study.threadlocal;

/**
 *需求：线程隔离
 * 在多线程并发场景下，每个线程中的变量都是独立的
 * 线程A：设置（变量1） 获取（变量1）
 * 线程B：设置（变量2） 获取（变量2）
 *
 * java中的线程调度是抢占式调度，碰巧情况下会返回正常结果，但是一定会出现线程之间错误调取数据的现象
 *
 *
 *
 * @author ryz2593
 * @date 2020/3/31 15:52
 */
public class MyDemo01_01 {
    //变量
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        MyDemo01_01 demo = new MyDemo01_01();
        for (int i = 0; i< 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    /**
                     * 每个线程存一个变量，过一会 取出这个变量
                     */
                    demo.setContent(Thread.currentThread().getName()+ "的数据");
                    System.out.println("------------------------");
                    System.out.println(Thread.currentThread().getName()+"--->"+demo.getContent());
                }
            });
            thread.setName("thread" + i);
            thread.start();
        }
    }
}
