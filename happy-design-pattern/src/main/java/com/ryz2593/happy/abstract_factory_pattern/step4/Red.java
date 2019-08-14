package com.ryz2593.happy.abstract_factory_pattern.step4;

import com.ryz2593.happy.abstract_factory_pattern.step3.Color;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
