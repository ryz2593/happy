package com.ryz2593.happy.prototype_pattern.step1;

import com.ryz2593.happy.prototype_pattern.step1.Shape;

/**
 * 步骤 2
 创建扩展了上面抽象类的实体类。
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
