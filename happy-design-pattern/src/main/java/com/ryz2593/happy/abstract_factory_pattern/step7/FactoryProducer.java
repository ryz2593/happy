package com.ryz2593.happy.abstract_factory_pattern.step7;

import com.ryz2593.happy.abstract_factory_pattern.step5.AbstractFactory;
import com.ryz2593.happy.abstract_factory_pattern.step6.ColorFactory;
import com.ryz2593.happy.abstract_factory_pattern.step6.ShapeFactory;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
