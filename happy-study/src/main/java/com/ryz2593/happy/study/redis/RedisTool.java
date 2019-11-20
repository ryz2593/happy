package com.ryz2593.happy.study.redis;

import redis.clients.jedis.Jedis;

/**
 * @author ryz2593
 */
public class RedisTool {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    public static boolean tryGetDistributedLock(Jedis jedis, String key, String requestId, int expireTime) {
        String result = jedis.set(key, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        return LOCK_SUCCESS.equals(result);
    }

}
