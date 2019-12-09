package com.ryz2593.happy.study.redis.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *JedisPool 使用
 * @author ryz2593
 */
public class JedisTest1 {
    public static void main(String[] args) {
        JedisPool pool = new JedisPool();
        //取JedisPool里面的jedis连接时，使用try-with-resource语句来保护Jedis对象
        // 用完自动close
        try (Jedis jedis = pool.getResource()){
            doSomething(jedis);
        }
    }

    private static void doSomething(Jedis jedis) {
        //code it here
    }
}
