package com.ryz2593.happy;

import com.google.common.collect.Lists;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ryz2593
 * @date 2019/9/9
 * @desc
 */
public class StringListArrayTransferUtil {

    public static void main(String[] args) {
        String productTypes = "1";
        List<Integer> integers = String2ListInteger(productTypes);
    }


    /**
     * String 根据分隔符 转换成 List<Integer>
     * @param str
     * @return
     */
    public static List<Integer> String2ListInteger(String str) {
        List<Integer> list = Lists.newArrayList();
        list = Arrays.stream(str.split(","))
                .mapToInt(t -> Integer.valueOf(t.trim())).boxed().collect(Collectors.toList());
        System.out.println("list = " + list);
        return list;
    }

    /**
     * 对象list 转成 List<Long>
     * @param objs
     * @return
     */
    public static List<Long> String2ListLong(List<DemoObject> objs) {
        List<Long> list = objs.stream().map(a -> Long.parseLong(String.valueOf(a.getId()))).collect(Collectors.toList());
        return list;
    }

    /**
     * String 根据分割符 转换成 数组
     * @param str
     * @return
     */
    public static int[] String2Array(String str) {
        int[] digits = Arrays.stream(str.split("\\."))
                .mapToInt(t -> Integer.valueOf(t.trim()))
                .boxed().collect(Collectors.toList())
                .stream().mapToInt(Integer::valueOf).toArray();
        return digits;
    }

    /**
     * Integer类型list转换成int[]
     * @param list
     * @return
     */
    public static int[] List2Array(List<Integer> list) {
        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        return array;
    }

    /**
     * int[] 装换成 List<Integer>
     * @param array
     * @return
     */
    public static List<Integer> array2List(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        return list;
    }

    /**
     * 将list 使用给定的分隔符转换成String 字符串
     * @param list
     * @param pattern
     * @return
     */
    public static String list2String(List<Integer> list, String pattern) {
        String str = StringUtils.join(list, pattern);
        return str;
    }

    /**排序
     * @param products
     */
    public static void sort(List<DemoObject> products) {
        List<DemoObject> newProducts = products.stream()
                .sorted(Comparator.comparingInt(DemoObject::getSort).reversed())
                .collect(Collectors.toList());
    }


}
