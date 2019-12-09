package com.ryz2593.happy.study.redis.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @author ryz2593
 */
public class Redis {
    private JedisPool pool;

    public Redis(JedisPool pool) {
        this.pool = pool;
    }

    public Redis() {

    }

    public void execute(CallWithJedis caller) {
        Jedis jedis = pool.getResource();
        try {
            caller.call(jedis);
        } catch (JedisConnectionException e) {
            //重试一次
            caller.call(jedis);
        } finally {
            jedis.close();
        }
    }
}
