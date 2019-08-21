package com.ryz2593.happy.prototype_pattern.step3;

import com.ryz2593.happy.prototype_pattern.step1.Shape;
import com.ryz2593.happy.prototype_pattern.step1.Circle;
import com.ryz2593.happy.prototype_pattern.step1.Rectangle;
import com.ryz2593.happy.prototype_pattern.step1.Square;

import java.util.Hashtable;

/**
 * 步骤 3
 创建一个类，从数据库获取实体类，并把它们存储在一个 Hashtable 中。
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap
            = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
