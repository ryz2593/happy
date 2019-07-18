package com.ryz2593.happy.study.dynamic.proxy.cglib;

/**
 * @author ryz2593
 * @date 2019/7/12
 * @desc
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        PersonService personService = (PersonService) new CglibProxyIntercepter().getProxy(PersonService.class);
        personService.getPerson("1");
        personService.setPerson();
    }
}
