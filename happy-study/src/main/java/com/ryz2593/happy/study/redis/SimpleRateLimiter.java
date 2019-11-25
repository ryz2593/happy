package com.ryz2593.happy.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

/**
 * 使用Redis实现简单限流策略
 *
 * @author ryz2593
 */
public class SimpleRateLimiter {
    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * 整体思路：
     * 每一个行为到来时，都维护一次时间窗口。
     * 将时间窗口之外的记录全部清理掉，只保留窗口内的记录。
     * zset集合中只有score值非常重要，value值没有特别的意义，只需要保证唯一的就可以。
     * 因为这几个连续的Redis操作都是针对同一个key的，使用pipeline可以显著提升Redis的存取效率。
     * 但这种方案也有缺点，因为要记录时间窗口内所有的行为记录，如果这个量很大，
     * 比如“限定60s内操作不超过100万次”之类，它是不适合做这样的限流的，因为会消耗大量的存储空间。
     *
     * @param userId
     * @param actionKey
     * @param period
     * @param maxCount
     * @return 当前的行为是否被允许
     * @throws IOException
     */
    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws IOException {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = jedis.pipelined();
        pipe.multi();
        //value 和 score 都使用毫秒时间戳
        pipe.zadd(key, nowTs, "" + nowTs);
        //移除时间窗口之前的行为记录，剩下的都是时间窗口内的
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        //获取窗口内的行为数量
        Response<Long> count = pipe.zcard(key);
        //设置zset过期时间，避免冷用户持续占用内存
        //过期时间应该等于时间窗口的长度，再多宽限1s
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        //比较数量是否超过允许的最大值
        return count.get() <= maxCount;
    }

    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis("172.17.28.129");
        SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
        for (int i = 0; i < 20; i++) {
            System.out.println(limiter.isActionAllowed("ryz2593", "click", 60, 5));
        }
    }
}
