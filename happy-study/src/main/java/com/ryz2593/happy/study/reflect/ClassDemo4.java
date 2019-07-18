package com.ryz2593.happy.study.reflect;

/**
 * @author ryz2593
 * @date 2019/7/15
 * @desc
 */
public class ClassDemo4 {
    public static void main(String[] args) {
        ClassUtil.printFieldMessage("hello");
        ClassUtil.printFieldMessage(new Integer(1));
    }
}
