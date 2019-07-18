package com.ryz2593.happy.study.dynamic.proxy.jdk;

/**
 * RealSubject
 * 真实主题类
 * @author ryz2593
 * @date 2019/7/12
 * @desc
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject do something");
    }
}
