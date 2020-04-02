package com.ryz2593.happy.study.objectpool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ryz2593
 * @date 2020/3/30 10:24
 */
public class Provider {
    private Map<Class<?>, ObjectUnit<?>> providers = new ConcurrentHashMap<Class<?>, ObjectUnit<?>>();
    private static Provider instance = new Provider();

    public Provider() {
    }

    public static Provider getInstance() {
        return  instance;
    }

    public <T> T getObj(Class<T> key) {
        ObjectUnit value = providers.get(key);
        if (value!=null) {
            return (T) value.checkOut();
        } else {
            value = new ObjectUnit<T>(key);
            providers.put(key, value);
            return (T) value.addItem();
        }
    }

    public <T> void renObj(T x) {
        if (providers.containsKey(x.getClass())) {
            ObjectUnit value = providers.get(x.getClass());
            value.checkIn(x);
        }
    }
}
