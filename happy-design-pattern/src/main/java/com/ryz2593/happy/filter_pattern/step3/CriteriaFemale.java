package com.ryz2593.happy.filter_pattern.step3;

import com.ryz2593.happy.filter_pattern.step1.Person;
import com.ryz2593.happy.filter_pattern.step2.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor ryz2593
 * @date 2019/8/20 22:31
 * @desc
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
