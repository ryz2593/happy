package com.ryz2593.happy.study.redis;

import com.google.common.collect.Lists;

import java.util.List;

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

    
}
