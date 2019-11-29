package com.ryz2593.happy.util;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;

/**
 * 遍历hashmap内容
 *
 * @author ryz2593
 */
public class HashMapUtil {
    public static void main(String[] args) {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("A", 100);
        map.put("B", 85);
        map.put("C", 60);
        map.put("D", 50);

        //1.使用for循环利用keySet进行遍历
        for (String key : map.keySet()) {
            System.out.println("grade： " + key + " score: " + map.get(key));
        }

        //2. 使用entrySet的迭代器
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println("grade： " + next.getKey() + " score: " + next.getValue());
        }

        //3. 使用for循环利用EntrySet进行遍历
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("grade： " + entry.getKey() + " score: " + entry.getValue());
        }

        //4. 使用keySet的迭代器
        Iterator<String> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            System.out.println("grade： " + key + " score: " + map.get(key));
        }

        //jdk8 使用forEach进行遍历
        map.forEach((k, v) -> System.out.println("grade： " + k + " score: " + v));

    }
}
