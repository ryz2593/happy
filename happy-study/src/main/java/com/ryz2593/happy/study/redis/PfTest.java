package com.ryz2593.happy.study.redis;

import redis.clients.jedis.Jedis;

public class PfTest {

    public static void main(String[] args) {
        String key = "codehole";
        Jedis jedis = new Jedis("172.17.28.129");
        for (int i = 0; i < 10000; i++) {
            jedis.pfadd(key, "user" + i);
            long total = jedis.pfcount(key);
            System.out.printf("%d %d\n", 10000, total);
        }
        jedis.close();
    }
}
