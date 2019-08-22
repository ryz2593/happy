package com.ryz2593.happy.strategy_pattern.step3;

import com.ryz2593.happy.strategy_pattern.step1.Strategy;

/**
 * @author ryz2593
 * @date 2019/8/16
 * @desc
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
