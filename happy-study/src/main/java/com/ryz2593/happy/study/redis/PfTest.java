package com.ryz2593.happy.study.redis;
import redis.clients.jedis.Jedis;

/**
 * HyperLogLog 数据结构进行估数，用于统计 如计算网页每天的用户的访问数量UV
 * 可以解决很多精度要求不是很高的统计问题
 * @author ryz2593
 */
public class PfTest {

    public static void main(String[] args) {
        String key = "codehole";
        Jedis jedis = new Jedis("172.17.28.129");
        for (int i = 0; i < 100; i++) {
            jedis.pfadd(key, "user" + i);
            long total = jedis.pfcount(key);
            System.out.printf("%d %d\n", 100, total);
        }
        jedis.close();
    }
}
