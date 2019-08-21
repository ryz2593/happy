package com.ryz2593.happy.prototype_pattern.step1;

import com.ryz2593.happy.prototype_pattern.step1.Shape;

/**
 * 步骤 2
 创建扩展了上面抽象类的实体类。
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
