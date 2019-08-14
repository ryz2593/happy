package com.ryz2593.happy.singleton_pattern;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    /**
     * 懒汉式，线程不安全
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * x线程安全
     *
     * @return
     */
    public static synchronized Singleton getInstanceThreadSafe() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 双检锁/双重校验锁（DCL，即 double-checked locking）
     * @return
     */
    public static Singleton getInstanceDCL() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
