package com.ryz2593.happy.filter_pattern.step4;

import com.ryz2593.happy.filter_pattern.step1.Person;
import com.ryz2593.happy.filter_pattern.step2.Criteria;
import com.ryz2593.happy.filter_pattern.step3.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor ryz2593
 * @date 2019/8/20 22:43
 * @desc
 */
public class CriteriaPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Robert","male","Single"));
        persons.add(new Person("John","male","Married"));
        persons.add(new Person("Laura","female","Married"));
        persons.add(new Person("Diana","female","Single"));
        persons.add(new Person("Mike","male","Single"));
        persons.add(new Person("Robby","male","Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemale = " + singleOrFemale);
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));

    }

    private static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("person : [ Name : " + person.getName()
            + ", Gender : " + person.getGender()
            + ",Marital Status : " + person.getMaritalStatus()
            + " ]");
        }

    }
}
