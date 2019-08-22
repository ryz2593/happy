package com.ryz2593.happy.strategy_pattern.step2;

import com.ryz2593.happy.strategy_pattern.step1.Tour;

/**
 * @author ryz2593
 * @date 2019/8/16
 * @desc
 */
public class Bike implements Tour {
    @Override
    public String traffic(String tool) {
        return "骑" + tool + "旅游";
    }
}
