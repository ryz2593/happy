package com.ryz2593.happy.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Redis事务
 * Redis禁止在multi和exec之间执行watch指令，必须在multi之前盯住关键变量，否则会出错。
 * @autor ryz2593
 * @date 2019/11/30 22:19
 * @desc
 */
public class TransactionDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        String userId = "abc";
        String key = keyFor(userId);
        //setnx初始化
        jedis.setnx(key, String.valueOf(5));
        System.out.println(doubleAccount(jedis, userId));
        jedis.close();
    }

    /**
     * 实现对余额加倍操作
     * @param jedis
     * @param userId
     * @return
     */
    private static int doubleAccount(Jedis jedis, String userId) {
        String key = keyFor(userId);
        while (true){
            jedis.watch(key);
            int value = Integer.parseInt(jedis.get(key));
            value *= 2;
            //multi指示事务的开始
            Transaction transaction = jedis.multi();
            transaction.set(key, String.valueOf(value));
            //exec指示事务的执行
            List<Object> result = transaction.exec();
            if (result != null) {
                //成功了
                break;
            }
        }
        //重新获取余额
        return Integer.parseInt(jedis.get(key));
    }

    private static String keyFor(String userId) {
        return String.format("account_%s", userId);
    }
}
