package com.ryz2593.happy.builder_pattern.step4;

import com.ryz2593.happy.builder_pattern.step3.Burger;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
