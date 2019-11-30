package com.ryz2593.happy.study.redis;

import redis.clients.jedis.Jedis;

/**
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

    private static int doubleAccount(Jedis jedis, String userId) {
        String key = keyFor(userId);
        return Integer.parseInt(jedis.get(key));
    }

    private static String keyFor(String userId) {
        return String.format("account_%s", userId);
    }
}
