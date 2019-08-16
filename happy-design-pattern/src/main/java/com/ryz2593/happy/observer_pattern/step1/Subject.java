package com.ryz2593.happy.observer_pattern.step1;

import com.ryz2593.happy.observer_pattern.step2.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ryz2593
 * @date 2019/8/15
 * @desc
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
