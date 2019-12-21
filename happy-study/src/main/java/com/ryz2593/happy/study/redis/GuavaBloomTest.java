package com.ryz2593.happy.study.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @autor ryz2593
 * @date 2019/12/21 21:10
 * @desc
 */
public class GuavaBloomTest {
    //预计要插入多少数据
    private static final int size = 10000;

    //期望的误判率，误判率不能为0
private static final double fpp = 0.01;


private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, fpp);

    public static void main(String[] args) {
        
    }


}
