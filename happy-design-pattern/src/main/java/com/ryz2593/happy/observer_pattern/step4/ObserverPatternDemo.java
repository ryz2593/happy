package com.ryz2593.happy.observer_pattern.step4;

import com.ryz2593.happy.observer_pattern.step1.Subject;
import com.ryz2593.happy.observer_pattern.step3.BinaryObserver;
import com.ryz2593.happy.observer_pattern.step3.HexaObserver;
import com.ryz2593.happy.observer_pattern.step3.OctalObserver;

/**
 * @author ryz2593
 * @date 2019/8/15
 * @desc
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(16);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
