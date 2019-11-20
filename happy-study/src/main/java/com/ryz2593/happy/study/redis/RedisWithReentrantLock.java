package com.ryz2593.happy.study.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author ryz2593
 */
public class RedisWithReentrantLock {
    private ThreadLocal<Map<String, Integer>> lockers = new ThreadLocal<>();

    private Jedis jedis;

    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    private boolean _lock(String key) {
        return jedis.set(key, "", "nx", "ex", 5L) == null;
    }

    private void _unlock(String key) {
        jedis.del(key);
    }

    
}
