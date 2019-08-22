package com.ryz2593.happy.strategy_pattern.step2;

import com.ryz2593.happy.strategy_pattern.step1.Strategy;

/**
 * @author ryz2593
 * @date 2019/8/16
 * @desc
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
