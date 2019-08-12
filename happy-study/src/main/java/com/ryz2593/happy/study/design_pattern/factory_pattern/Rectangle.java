package com.ryz2593.happy.study.design_pattern.factory_pattern;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
