package com.ryz2593.happy.study.dynamic.proxy.cglib;

/**
 * @author ryz2593
 * @date 2019/7/12
 * @desc
 */
public class PersonService {
    public PersonService() {
        System.out.println("PersonService构造");
    }

    final public Person getPerson(String code) {
        System.out.println("PersonService:getPerson>>"+code);
        return null;
    }

    public void setPerson() {
        System.out.println("PersonService:setPerson");
    }

    class Person{}
}
