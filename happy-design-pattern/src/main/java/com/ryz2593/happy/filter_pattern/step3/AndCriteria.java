package com.ryz2593.happy.filter_pattern.step3;

import com.ryz2593.happy.filter_pattern.step1.Person;
import com.ryz2593.happy.filter_pattern.step2.Criteria;

import java.util.List;

/**
 * @autor ryz2593
 * @date 2019/8/20 22:36
 * @desc
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
