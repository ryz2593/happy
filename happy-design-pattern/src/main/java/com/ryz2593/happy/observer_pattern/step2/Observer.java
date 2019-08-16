package com.ryz2593.happy.observer_pattern.step2;

import com.ryz2593.happy.observer_pattern.step1.Subject;

/**
 * @author ryz2593
 * @date 2019/8/15
 * @desc
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
