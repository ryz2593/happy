package com.ryz2593.happy.study.objectpool.exam2;

/**
 * 内部使用的用于保存对象池中对象的类。
 * 此类中有两个成员，一个是对象，另一个是指示此对象是否正在使用的标志 。
 */
class PooledObject {

    // 对象
    Object objection = null;
    // 此对象是否正在使用的标志，默认没有正在使用
    boolean busy = false;

    // 构造函数，根据一个 Object 构告一个 PooledObject 对象
    public PooledObject(Object objection) {

        this.objection = objection;

    }

    // 返回此对象中的对象
    public Object getObject() {
        return objection;
    }

    // 设置此对象的，对象
    public void setObject(Object objection) {
        this.objection = objection;

    }

    // 获得对象对象是否忙
    public boolean isBusy() {
        return busy;
    }

    // 设置对象的对象正在忙
    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}