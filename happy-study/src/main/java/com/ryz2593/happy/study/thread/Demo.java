package com.ryz2593.happy.study.thread;

/**
 * @author ryz2593
 * @date 2019/7/16
 * @desc
 */
public class Demo {
    public static void main(String[] args) {
        CustomResult<Integer> customResult = new CustomResult<Integer>() {
            @Override
            public Integer doRun() {
                System.out.println("Thread Name:" + Thread.currentThread().getName());
                return (int) (System.currentTimeMillis() / 1000);
            }
        };

        Result<Integer> result = new Result<>(customResult);
        new Thread(result).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("当前时间:[" + result.getData() + "]s");

    }
}
