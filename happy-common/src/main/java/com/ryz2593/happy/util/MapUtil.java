package com.ryz2593.happy.util;

import java.util.Map;

/**
 * @author ryz2593
 * @date 2020/3/20 9:32
 */
public class MapUtil {

    public static void keySetLoop(Map map) {
        for (Object o : map.keySet()) {
            System.out.println(o + ": " + map.get(o));
        }
//        for (String s : map.keySet()) {
//            System.out.println(s + ": " + map.get(s));
//        }
    }
}
