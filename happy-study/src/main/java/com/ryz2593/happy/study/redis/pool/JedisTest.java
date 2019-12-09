package com.ryz2593.happy.study.redis.pool;

import redis.clients.jedis.Jedis;

/**
 * @author ryz2593
 */
public class JedisTest {
    public static void main(String[] args) {

        Redis redis = new Redis();
        final Holder<Long> countHolder = new Holder<>();
        redis.execute(jedis->{
            long count = jedis.zcard("codehole");
            countHolder.value(count);
        });
        System.out.println(countHolder.value());

    }
}