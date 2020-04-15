package com.ryz2593.happy.study.reflect;

import com.google.common.collect.Maps;
import com.ryz2593.happy.util.MapUtil;
import org.apache.commons.collections.MapUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * 使用反射获取对象中各个属性对应的值
 * 应用场景：如果在实际开发过程中想要将从数据库中查询的对象中的每一个字段对应的值写入到excel中，
 * 一般的写法是：解析对象中的每一个属性使用get方法获取对象中的属性对应的值写入到excel中，
 * 如果对象有很多属性则需要每一个属性都使用一次get方法
 * 使用反射：1. 获取对象所有的属性
 * Field[] declaredFields = user.getClass().getDeclaredFields();
 * 2. 遍历属性数组，将属性对应的accessAble属性设置为true
 * for (Field field : declaredFields) {
 * field.setAccessible(true);
 * 3. 使用反射获取对象的该属性对应的值 field.get(user)
 * map.put(field.getName(), field.get(user));
 *
 * @author ryz2593
 * @date 2020/3/20 9:18
 */
public class PrintUserInfoByReflect {
    public static void main(String[] args) {
        User user = new User();
        Map<String, Object> map = getUserInfoMap(user);
        MapUtil.keySetLoop(map);
        System.out.println("--------------------------------------------");

        //一：通过全限定名获取类对象
        Class userClass = null;
        try {
            userClass = Class.forName("com.ryz2593.happy.study.reflect.PrintUserInfoByReflect.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(userClass);

        //二：通过类直接获取类对象
        Class userClass1 = User.class;
        System.out.println(userClass1);

        //三：通过类实例获取对象
        Class userClass2 = user.getClass();
        System.out.println(userClass2);
        System.out.println(userClass.equals(userClass1));
        System.out.println(userClass1.equals(userClass2));

        System.out.println("--------------------------------------------");

        Constructor constructors = null;
        try {
            constructors = userClass.getConstructor(String.class, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            User o = (User) constructors.newInstance("liSi", "23@qq.com");
            System.out.println("userName: " + o.getUserName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }




    }

    public static Map<String, Object> getUserInfoMap(User user) {
        user.setUserName("zs");
        user.setEmail("zs@qq.com");

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


    private String userName;
    private String email;

    public User() {
    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

