package com.ryz2593.happy.strategy_pattern.step4;

import com.ryz2593.happy.strategy_pattern.step2.Bike;
import com.ryz2593.happy.strategy_pattern.step2.Car;
import com.ryz2593.happy.strategy_pattern.step3.Transportation;

/**
 * @author ryz2593
 * @date 2019/8/16
 * @desc
 */
public class TourDemo {
    public static void main(String[] args) {
        Transportation transportation = new Transportation(new Bike());
        System.out.println("tour tool : " + transportation.tool("bike"));

        transportation = new Transportation(new Car());
        System.out.println("tour tool : " + transportation.tool("car"));
    }
}
