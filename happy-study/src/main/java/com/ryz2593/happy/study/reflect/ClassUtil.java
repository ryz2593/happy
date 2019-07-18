package com.ryz2593.happy.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ryz2593
 * @date 2019/7/15
 * @desc
 */
public class ClassUtil {
    /**
     * 打印类的信息，包括成员函数、成员变量
     *
     * @param obj 该对象所属类的信息
     */
    public static void printClassMessage(Object obj) {
        //要获取类的信息 首先要获取类的类类型
        Class c = obj.getClass(); //传递的是哪个子类的对象，c就是该子类的类类型
        //获取类的名称
        System.out.println("类的名称是：" + c.getName());

        /**
         * Method类  ， 方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public函数，包括父类继承而来的
         * getDeclaredMethods()获取的是所有该类声明的方法，包括private
         */
        Method[] ms = c.getMethods();
        Method[] declaredMethods = c.getDeclaredMethods();
        for (int i = 0; i < ms.length; i++) {
            //得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.println(returnType.getName() + " ");
            //得到方法的名称
            System.out.print(ms[i].getName() + "(");
            //获取参数类型的类类型
            Class[] parameterTypes = ms[i].getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.print(parameterType.getName() + ", ");
            }
            System.out.print(")");

            printFieldMessage(c);

        }
    }

    public static void printFieldMessage(Object obj) {
        Class c = obj.getClass();
        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public成员变量的信息
         * getDeclaredFields() 获取所有自己声明的的成员变量信息
         */
//        Field[] fs = c.getFields();
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs) {
            //得到成员变量的类类型
            Class<?> fieldType = field.getType();
            String typeName = fieldType.getName();

            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    public static void printConstructMessage(Object obj) {
        Class c = obj.getClass();
        /**
         *java.lang.Constructor中封装了构造函数的信息
         * getConstructors() 得到所有的public的构造函数
         * getDeclaredConstructors() 得到所有的构造函数
         */
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.print(constructor.getName() + "(");
            //获取构造函数的参数列表->得到的是参数列表的类类型
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.print(parameterType.getName() + ",");
            }
            System.out.println(")");
        }
    }
}
