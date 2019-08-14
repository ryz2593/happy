package com.ryz2593.happy.abstract_factory_pattern.step2;

import com.ryz2593.happy.abstract_factory_pattern.step1.Shape;

/**
 * 创建实现接口的实体类。
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
