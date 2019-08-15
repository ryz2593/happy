package com.ryz2593.happy.builder_pattern.step3;

import com.ryz2593.happy.builder_pattern.step1.Item;
import com.ryz2593.happy.builder_pattern.step1.Packing;
import com.ryz2593.happy.builder_pattern.step2.Wrapper;

/**
 * 步骤 3
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
