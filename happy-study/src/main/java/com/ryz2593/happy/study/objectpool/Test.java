package com.ryz2593.happy.study.objectpool;

/**
 * @author ryz2593
 * @date 2020/3/30 10:35
 */
public class Test {
    public static void main(String[] args) {
        Provider provider = new Provider();

        String obj = provider.getObj(String.class);
        System.out.println(obj);

        String obj2 = provider.getObj(String.class);
        System.out.println(obj2 == obj);

    }
}
