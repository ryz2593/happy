package com.ryz2593.happy.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ryz2593
 */
public class Lambda {

    public static void main(String[] args) {
        String configValue = "1.0.0";
        string2List(configValue);
    }

    /**
     * 将数字字符串转成Integer类型的list列表
     * @param str
     */
    private static List<Integer> string2List(String str) {
        List<Integer> mList = Arrays.stream(str.split("\\."))
                .mapToInt(t -> Integer.valueOf(t.trim())).boxed().collect(Collectors.toList());
        return mList;
    }

    /**
     * 将数字字符串转成int[]
     * @param str
     * @return
     */
    private static int[] string2Array(String str) {
        int[] digits = Arrays.stream(str.split("\\."))
                .mapToInt(t -> Integer.valueOf(t.trim()))
                .boxed().collect(Collectors.toList())
                .stream().mapToInt(Integer::valueOf).toArray();
        return digits;
    }

    /**
     * 将int数组转成List<Integer>
     * @param array
     * @return
     */
    private static List<Integer> array2List(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        return list;
    }




}
