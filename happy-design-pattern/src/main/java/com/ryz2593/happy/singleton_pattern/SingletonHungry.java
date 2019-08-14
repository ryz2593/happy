package com.ryz2593.happy.singleton_pattern;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();
    private SingletonHungry(){}

    public static SingletonHungry getInstance() {
        return instance;
    }
}
