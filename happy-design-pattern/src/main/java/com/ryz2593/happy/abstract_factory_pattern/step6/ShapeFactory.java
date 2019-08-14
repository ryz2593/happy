package com.ryz2593.happy.abstract_factory_pattern.step6;

import com.ryz2593.happy.abstract_factory_pattern.step1.Shape;
import com.ryz2593.happy.abstract_factory_pattern.step2.Circle;
import com.ryz2593.happy.abstract_factory_pattern.step2.Rectangle;
import com.ryz2593.happy.abstract_factory_pattern.step2.Square;
import com.ryz2593.happy.abstract_factory_pattern.step3.Color;
import com.ryz2593.happy.abstract_factory_pattern.step5.AbstractFactory;

/**
 * 创建一个工厂，生成基于给定信息的实体类的对象。
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
