package com.ryz2593.happy.factory_pattern.step3;

import com.ryz2593.happy.factory_pattern.step1.Shape;
import com.ryz2593.happy.factory_pattern.step2.Circle;
import com.ryz2593.happy.factory_pattern.step2.Rectangle;
import com.ryz2593.happy.factory_pattern.step2.Square;

/**
 * 创建一个工厂，生成基于给定信息的实体类的对象。
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class ShapeFactory {
    //使用 getShape 方法获取形状类型的对象
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
}
