package com.ryz2593.happy.strategy_pattern.step2;

import com.ryz2593.happy.strategy_pattern.step1.Tour;

/**
 * @author ryz2593
 * @date 2019/8/16
 * @desc
 */
public class Car implements Tour {
    @Override
    public String traffic(String tool) {
        return "开" + tool + "旅游";
    }
}
