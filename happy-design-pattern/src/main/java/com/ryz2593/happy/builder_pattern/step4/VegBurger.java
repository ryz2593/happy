package com.ryz2593.happy.builder_pattern.step4;

import com.ryz2593.happy.builder_pattern.step3.Burger;

/**
 * 步骤 4
 创建扩展了 Burger 和 ColdDrink 的实体类。
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
