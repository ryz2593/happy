package com.ryz2593.happy.abstract_factory_pattern.step5;

import com.ryz2593.happy.abstract_factory_pattern.step1.Shape;
import com.ryz2593.happy.abstract_factory_pattern.step3.Color;

/**
 * 为 Color 和 Shape 对象创建抽象类来获取工厂
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
