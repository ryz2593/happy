package com.ryz2593.happy.study.thread;

/**
 * @author ryz2593
 * @date 2019/7/16
 * @desc
 */
public interface CustomResult<T> {
    /**
     * 获得需要的结果
     * @return
     */
    T doRun();
}
