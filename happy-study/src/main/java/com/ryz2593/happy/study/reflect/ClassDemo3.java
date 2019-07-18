package com.ryz2593.happy.study.reflect;

/**
 * @author ryz2593
 * @date 2019/7/15
 * @desc
 */
public class ClassDemo3 {
    public static void main(String[] args) {
        String s = "hello";
        ClassUtil.printClassMessage(s);

        Integer n1 = 1;
        ClassUtil.printClassMessage(n1);
    }
}
