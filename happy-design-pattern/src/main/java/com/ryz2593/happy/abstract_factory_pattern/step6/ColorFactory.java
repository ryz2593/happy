package com.ryz2593.happy.abstract_factory_pattern.step6;

import com.ryz2593.happy.abstract_factory_pattern.step1.Shape;
import com.ryz2593.happy.abstract_factory_pattern.step3.Color;
import com.ryz2593.happy.abstract_factory_pattern.step4.Blue;
import com.ryz2593.happy.abstract_factory_pattern.step4.Green;
import com.ryz2593.happy.abstract_factory_pattern.step4.Red;
import com.ryz2593.happy.abstract_factory_pattern.step5.AbstractFactory;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
