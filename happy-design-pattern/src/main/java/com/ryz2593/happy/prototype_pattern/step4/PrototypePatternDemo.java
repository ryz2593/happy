package com.ryz2593.happy.prototype_pattern.step4;

import com.ryz2593.happy.prototype_pattern.step1.Shape;
import com.ryz2593.happy.prototype_pattern.step3.ShapeCache;

/**
 * 步骤 4
 PrototypePatternDemo
 使用 ShapeCache 类来获取存储在 Hashtable 中的形状的克隆。
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
