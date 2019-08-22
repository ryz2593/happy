package com.ryz2593.happy.strategy_pattern.step3;

import com.ryz2593.happy.strategy_pattern.step1.Tour;

/**
 * @author ryz2593
 * @date 2019/8/16
 * @desc
 */
public class Transportation {
    private Tour tour;

    public Transportation(Tour tour) {
        this.tour = tour;
    }

    public String tool(String tool) {
        return tour.traffic(tool);
    }
}
