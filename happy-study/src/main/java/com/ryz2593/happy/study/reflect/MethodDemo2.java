package com.ryz2593.happy.study.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ryz2593
 * @date 2019/7/16
 * @desc
 */
public class MethodDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add(10);
        list1.add("hello");
        //list1.add(20);错误的
        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        System.out.println(c1 == c2);

        /**
         * c1 == c2 结果返回true 说明编译之后集合的泛型是去泛型化的
         * java集合中的泛型，是防止错误输入的，只在编译阶段有效
         * 绕过编译就无效了
         * 验证：我们可以通过方法的反射， 来绕过编译
         */
        try {
            Method method = c1.getMethod("add", Object.class);
            method.invoke(list, "hello");
            System.out.println(list.size());
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
