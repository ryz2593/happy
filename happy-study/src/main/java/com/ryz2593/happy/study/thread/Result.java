package com.ryz2593.happy.study.thread;

/**
 * @author ryz2593
 * @date 2019/7/16
 * @desc
 */
public class Result<T> implements Runnable {

    private T data;

    private CustomResult<T> customResult;

    public Result(CustomResult<T> customResult) {
        this.customResult = customResult;
    }

    @Override
    public void run() {
        this.data = customResult.doRun();
    }

    public T getData() {
        return data;
    }
}
