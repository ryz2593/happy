package com.ryz2593.happy.study.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import javafx.concurrent.Task;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.UUID;

/**
 * @author ryz2593
 */
public class RedisDelayingQueue<T> {
    static class TaskItem<T> {
        public String id;
        public T msg;
    }
    //fastjson序列化对象中存在generic类型时，需要使用TypeReference
    private Type TaskType = new TypeReference<TaskItem<T>>() {}.getType();
    private Jedis jedis;
    private String queueKey;

    public RedisDelayingQueue(Jedis jedis, String queueKey) {
        this.jedis = jedis;
        this.queueKey = queueKey;
    }

    public void delay(T msg) {
        TaskItem<T> task = new TaskItem<T>();
        //分配唯一的uuid
        task.id = UUID.randomUUID().toString();
        task.msg = msg;
        //fastjson 序列化
        String s = JSON.toJSONString(task);
        //塞入延时队列， 5s 后再试
        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, s);
    }

    public void loop() {
        while (!Thread.interrupted()) {
            //只取一条
            Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()) {
                try {
                    //歇会继续
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            String s = values.iterator().next();
            //抢到了
            if (jedis.zrem(queueKey, s) > 0) {
                //fastjson反序列化
                TaskItem<T> task = JSON.parseObject(s, TaskType);
                this.handleMsg(task.msg);
            }
        }
    }

    private void handleMsg(T msg) {
        System.out.println(msg);
    }

    
}
