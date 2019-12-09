package com.ryz2593.happy.study.redis.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

class RedisPool {
    private JedisPool pool;

    public RedisPool(JedisPool pool) {
        this.pool = pool;
    }

    public RedisPool() {

    }

    public void execute(CallWithJedis caller) {
        try (Jedis jedis = pool.getResource()){
            caller.call(jedis);
        }
    }
}