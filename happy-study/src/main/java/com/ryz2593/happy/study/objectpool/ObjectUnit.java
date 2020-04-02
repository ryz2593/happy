package com.ryz2593.happy.study.objectpool;

import java.util.ArrayList;
import java.util.List;

/**
 * 当调用对象时，不使用常规的new 构造子的方式，而是通过一个对象池操作。
 * 即如果池中存在该对象，则取出；如果不存在，则新建一个对象并存储在池中。当使用完该对象后，则将该对象的归还给对象池。
 *
 * @author ryz2593
 * @date 2020/3/30 10:09
 */
public class ObjectUnit<T> {
    private Class<T> type;
    private List<T> items = new ArrayList<T>();
    private List<Boolean> checkOut = new ArrayList<>();
    private int semaphore;

    public ObjectUnit(Class<T> type) {
        this.type = type;
    }

    public synchronized T addItem() {
        T obj = null;
        try {
            obj = type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        items.add(obj);
        checkOut.add(false);
        return obj;
    }

    public synchronized T checkOut() {
        if (semaphore < items.size()) {
            semaphore++;
            return getItem();
        } else {
            return addItem();
        }
    }

    private synchronized T getItem() {
        for (int index = 0; index < checkOut.size(); index++) {
            if (!checkOut.get(index)) {
                checkOut.set(index, true);
                return items.get(index);
            }
        }
        return null;
    }

    public synchronized void checkIn(T x) {
        if (releaseItem(x)) {
            semaphore--;
        }
    }

    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        //不在list中
        if (index == -1) {
            return false;
        }
        if (checkOut.get(index)) {
            checkOut.set(index, false);
            return true;
        }
        return false;
    }
}
