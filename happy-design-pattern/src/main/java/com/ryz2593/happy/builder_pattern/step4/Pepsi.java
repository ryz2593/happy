package com.ryz2593.happy.builder_pattern.step4;

import com.ryz2593.happy.builder_pattern.step3.ColdDrink;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
