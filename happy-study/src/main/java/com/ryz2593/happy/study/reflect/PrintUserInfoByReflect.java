package com.ryz2593.happy.study.reflect;

import com.google.common.collect.Maps;
import com.ryz2593.happy.util.MapUtil;
import org.apache.commons.collections.MapUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

/**
 * 使用反射获取对象中各个属性对应的值
 * 应用场景：如果在实际开发过程中想要将从数据库中查询的对象中的每一个字段对应的值写入到excel中，
 * 一般的写法是：解析对象中的每一个属性使用get方法获取对象中的属性对应的值写入到excel中，
 *             如果对象有很多属性则需要每一个属性都使用一次get方法
 * 使用反射：1. 获取对象所有的属性
 *              Field[] declaredFields = user.getClass().getDeclaredFields();
 *         2. 遍历属性数组，将属性对应的accessAble属性设置为true
 *              for (Field field : declaredFields) {
 *                  field.setAccessible(true);
 *         3. 使用反射获取对象的该属性对应的值 field.get(user)
 *              map.put(field.getName(), field.get(user));
 * @author ryz2593
 * @date 2020/3/20 9:18
 */
public class PrintUserInfoByReflect {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUserName("zs");
        user.setAge(20);
        user.setSex(1);
        user.setEmail("zs@qq.com");
        user.setBirthday(new Date());
        Map<String, Object> map = getUserInfoMap(user);
        MapUtil.keySetLoop(map);
//        for (String s : map.keySet()) {
//            System.out.println(s + ": " + map.get(s));
//        }

    }

    public static Map<String, Object> getUserInfoMap(User user) {
        Map<String, Object> map = Maps.newHashMap();
        Field[] declaredFields = user.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(user));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}

class User {
    private Long id;
    private String userName;
    private Integer age;
    private Integer sex;
    private String email;
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
