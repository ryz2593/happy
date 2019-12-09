package com.ryz2593.happy.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *JedisPool 使用
 * @author ryz2593
 */
public class JedisTest {
    public static void main(String[] args) {
        JedisPool pool = new JedisPool();
        try (Jedis jedis = pool.getResource()){
            doSomething(jedis);
        }
    }

    private static void doSomething(Jedis jedis) {
        //code it here
    }
}
