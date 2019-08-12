package com.ryz2593.happy.factory_pattern;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
