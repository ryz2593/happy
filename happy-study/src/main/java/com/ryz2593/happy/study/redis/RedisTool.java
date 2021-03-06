package com.ryz2593.happy.study.redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * Redis分布式锁
 * @author ryz2593
 */
public class RedisTool {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param key 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String key, String requestId, int expireTime) {
        String result = jedis.set(key, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        return LOCK_SUCCESS.equals(result);
    }

    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param key 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String key, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        //在eval命令执行Lua代码的时候，Lua代码将被当成一个命令去执行，并且直到eval命令执行完成，Redis才会执行其他命令。
        //确保操作是原子性的
        Object eval = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(requestId));
        return RELEASE_SUCCESS.equals(eval);
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.17.28.129");
        System.out.println(tryGetDistributedLock(jedis, "looo", "rrr", 5));
        System.out.println(tryGetDistributedLock(jedis, "looo", "rrr", 5));
        System.out.println(releaseDistributedLock(jedis, "looo", "rrr"));
        System.out.println(releaseDistributedLock(jedis, "looo", "rrr"));
    }

}
