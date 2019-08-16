package com.ryz2593.happy.observer_pattern.step3;

import com.ryz2593.happy.observer_pattern.step1.Subject;
import com.ryz2593.happy.observer_pattern.step2.Observer;

/**
 * @author ryz2593
 * @date 2019/8/15
 * @desc
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binay String : " + Integer.toBinaryString(subject.getState()));
    }
}
