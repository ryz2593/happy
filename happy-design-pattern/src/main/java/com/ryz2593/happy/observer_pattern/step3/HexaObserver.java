package com.ryz2593.happy.observer_pattern.step3;

import com.ryz2593.happy.observer_pattern.step1.Subject;
import com.ryz2593.happy.observer_pattern.step2.Observer;

/**
 * @author ryz2593
 * @date 2019/8/15
 * @desc
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hexa String : " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
