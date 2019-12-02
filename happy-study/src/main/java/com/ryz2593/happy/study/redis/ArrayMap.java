package com.ryz2593.happy.study.redis;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 使用数组来模拟HashMap的增删改操作
 * @author ryz2593
 */
public class ArrayMap<K,V> {
    private List<K> keys = Lists.newArrayList();
    private List<V> values = Lists.newArrayList();

    public V put(K k, V v) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(k)) {
                V oldv = values.get(i);
                values.set(i, v);
                return oldv;
            }
        }
        keys.add(k);
        values.add(v);
        return null;
    }

    public V get(K k) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(k)) {
                return values.get(i);
            }
        }
        return null;
    }

    public V delete(K k) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(k)) {
                keys.remove(i);
                return values.remove(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
        arrayMap.put("A", 90);
        arrayMap.put("B", 80);
        System.out.println(arrayMap.keys.size());
        System.out.println(arrayMap.get("B"));
        arrayMap.delete("A");
        System.out.println(arrayMap.keys.size());
    }
}
