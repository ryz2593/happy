package com.ryz2593.happy.study.reflect;

import java.lang.reflect.Method;

/**
 * @author ryz2593
 * @date 2019/7/16
 * @desc
 */
public class MethodDemo1 {
    public static void main(String[] args) {
        //要获取print(int, int)方法，1. 要获取一个方法就是获取类的信息，获取类的信息首先要获取类的类类型
        A a1 = new A();
        Class c = a1.getClass();

        /**
         * 2. 获取方法 名称和参数列表决定
         * getMethod()获取的是public的方法
         * getDeclaredMethod()获取的是自己所有的方法
         *
         */

        try {
            Method method = c.getMethod("print", int.class, int.class);
            //Method method = c.getMethod("print", new Class[] {int.class, int.class});
            method.invoke(a1, 10, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("==============================================");
        try {
            Method m1 = c.getMethod("print", String.class, String.class);
            m1.invoke(a1, "Hello", "WORLD");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("==============================================");
        try {
            Method m2 = c.getMethod("print");
            m2.invoke(a1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static class A{
        public void print(){
            System.out.println("helloworld");
        }
        public void print(int a, int b) {
            System.out.println(a+b);
        }
        public void print(String a, String b) {
            System.out.println(a.toUpperCase() + "," + b.toLowerCase());
        }
    }
}
