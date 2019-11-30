package com.ryz2593.happy.study.thread.callable;

import java.util.concurrent.*;

/**
 * @autor ryz2593
 * @date 2019/12/1 0:08
 * @desc
 */
public class Race implements Callable<Integer> {
    // 赛跑者的名字
    private String name;
    // 延时多少
    private Long time;
    // 跑了多少步
    private int step;
    // 标志是否能跑
    private boolean flag;

    public Race(String name, Long time, boolean flag) {
        super();
        this.name = name;
        this.time = time;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public Integer call() throws Exception {
        // 只有当 flag 为 true 的时候才赛跑
        while (this.flag) {
            Thread.sleep(this.time);
            this.step++;
            System.out.println(this.name + "--跑了--" + this.step + "步");
        }
        return this.step;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 实例化Callable的实例
        Race tortoise = new Race("乌龟", 1000L, true);
        Race rabbit = new Race("兔子", 300L, true);

        // new 两个线程,固定线程
        ExecutorService service = Executors.newFixedThreadPool(2);

        // 需要获取返回值的时候使用线程.submit(Callable<T>) 返回 Futrue 对象，
        // 使用 Future.get() 方法获取返回值
        Future<Integer> tortoiseSer = service.submit(tortoise);
        Future<Integer> rabbitSer = service.submit(rabbit);

        // 线程休眠5秒，五秒后停止赛跑
        Thread.sleep(5000L);
        tortoise.setFlag(false);
        rabbit.setFlag(false);

        int tortoiseStep = tortoiseSer.get();
        int rabbitStep = rabbitSer.get();

        System.out.println("乌龟一共跑了--" + tortoiseStep + "--步");
        System.out.println("兔子一共跑了--" + rabbitStep + "--步");

        // 关闭服务，ExecuteServer 执行完毕之后并不会自己关闭服务，需要手动关闭
        service.shutdown();
    }
}
