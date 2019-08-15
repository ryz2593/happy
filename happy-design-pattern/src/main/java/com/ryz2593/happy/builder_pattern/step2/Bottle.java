package com.ryz2593.happy.builder_pattern.step2;

import com.ryz2593.happy.builder_pattern.step1.Packing;

/**
 * 创建实现 Packing 接口的实体类。
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
