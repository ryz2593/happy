package com.ryz2593.happy.study.redis.pool;

import redis.clients.jedis.Jedis;

interface CallWithJedis {
    public void call(Jedis jedis);
}
