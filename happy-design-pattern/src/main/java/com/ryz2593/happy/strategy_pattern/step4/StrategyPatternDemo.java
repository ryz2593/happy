package com.ryz2593.happy.strategy_pattern.step4;

import com.ryz2593.happy.strategy_pattern.step2.OperationAdd;
import com.ryz2593.happy.strategy_pattern.step2.OperationMultiply;
import com.ryz2593.happy.strategy_pattern.step2.OperationSubstract;
import com.ryz2593.happy.strategy_pattern.step3.Context;

/**
 * @author ryz2593
 * @date 2019/8/16
 * @desc
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
