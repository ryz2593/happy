package com.ryz2593.happy.study.thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @autor ryz2593
 * @date 2019/12/16 22:05
 * @desc
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        /**
         * corePoolSize： 线程池核心线程数
         * maximumPoolSize：线程池最大数
         * keepAliveTime： 空闲线程存活时间
         * unit： 时间单位
         * workQueue： 线程池所使用的缓冲队列
         * threadFactory：线程池创建线程使用的工厂
         * handler： 线程池对拒绝任务的处理策略
         */
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);

        // 预启动所有核心线程
        executor.prestartAllCoreThreads();

        for (int i = 1; i <= 10; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
        }

        //阻塞主线程
        System.in.read();
    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    public static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println(r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
        }
    }

    static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            // 开始时间
            long start = System.currentTimeMillis();
            // 模拟数据List
            List<String> list = new ArrayList<String>();
            for (int i = 1; i <= 3000; i++) {
                list.add(i + "");
            }
            // 每500条数据开启一条线程
            int threadSize = 500;
            // 总数据条数
            int dataSize = list.size();
            // 线程数
            int threadNum = dataSize / threadSize + 1;
            // 定义标记,过滤threadNum为整数
            boolean special = dataSize % threadSize == 0;
            // 创建一个线程池
            ExecutorService exec = Executors.newFixedThreadPool(threadNum);
            // 定义一个任务集合
            List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
            Callable<Integer> task = null;
            List<String> cutList = null;
            // 确定每条线程的数据
            for (int i = 0; i < threadNum; i++) {
                if (i == threadNum - 1) {
                    if (special) {
                        break;
                    }
                    cutList = list.subList(threadSize * i, dataSize);
                } else {
                    cutList = list.subList(threadSize * i, threadSize * (i + 1));
                }
                // System.out.println("第" + (i + 1) + "组：" + cutList.toString());
                final List<String> listStr = cutList;
                task = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        System.out.println(Thread.currentThread().getName() + "线程：" + listStr);
                        return 1;
                    }
                };
                // 这里提交的任务容器列表和返回的Future列表存在顺序对应的关系
                tasks.add(task);
            }
            try {
                List<Future<Integer>> results = exec.invokeAll(tasks);
                for (Future<Integer> future : results) {
                    System.out.println(future.get());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 关闭线程池
            exec.shutdown();
            System.out.println("线程任务执行结束");
            System.err.println("执行任务消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }
}