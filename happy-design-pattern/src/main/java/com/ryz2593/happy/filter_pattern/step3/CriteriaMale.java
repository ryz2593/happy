package com.ryz2593.happy.filter_pattern.step3;

import com.ryz2593.happy.filter_pattern.step1.Person;
import com.ryz2593.happy.filter_pattern.step2.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * 步骤 3
 * 创建实现了 Criteria 接口的实体类。
 *
 * @autor ryz2593
 * @date 2019/8/20 22:27
 * @desc
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
