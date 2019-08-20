package com.ryz2593.happy.filter_pattern.step1;

/**
 *
 * 步骤 1
 * 创建一个类，在该类上应用标准。
 *
 * @autor ryz2593
 * @date 2019/8/20
 * @desc
 */
public class Person {
    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
