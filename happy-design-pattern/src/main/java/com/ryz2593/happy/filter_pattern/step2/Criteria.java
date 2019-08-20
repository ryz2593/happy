package com.ryz2593.happy.filter_pattern.step2;

import com.ryz2593.happy.filter_pattern.step1.Person;

import java.util.List;

/**
 * 步骤 2
 * 为标准（Criteria）创建一个接口。
 *
 * @autor ryz2593
 * @date 2019/8/20 22:25
 * @desc
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
