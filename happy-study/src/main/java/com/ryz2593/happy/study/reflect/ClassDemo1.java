package com.ryz2593.happy.study.reflect;

/**
 * @author ryz2593
 * @date 2019/7/12
 * @desc
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        //Foo的实例对象如何表示
        //foo1就表示出来了
        Foo foo1 = new Foo();
        //Foo这个类也是一个实例对象，Class类的实例对象，如何表示呢
        //任何一个类都是Class的实例对象，这个实例对象有三种表现形式
        //第一种表现形式==>实际告诉我们任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;

        //第二种表现形式 已经知道该类的对象通过getClass()方法
        Class c2 = foo1.getClass();
        /**
         * 官网 c1,c2表示了Foo类的类类型(class type)
         * 完事万物皆对象
         * 类也是对象，是Class类的实例对象
         * 这个对象我们称之为该类的类类型
         */

        //不管c1还是c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println("c1 == c2 : " + (c1 == c2));

        //第三种表现形式
        Class c3 = null;
        try {
            c3 = Class.forName("com.ryz2593.study.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("c2 == c3 : " + (c3 == c2));

        //可以通过类的类类型创建该类的对象实例->通过c1 or c2 or c3创建Foo的实例对象
        try {
            Foo foo = (Foo) c1.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}

class Foo {
    void print() {
        System.out.println("this is foo class");
    }
}

