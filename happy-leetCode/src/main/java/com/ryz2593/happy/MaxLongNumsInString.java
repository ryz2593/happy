package com.ryz2593.happy;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 *
 * @author ryz2593
 */
public class MaxLongNumsInString {

    public static void main(String[] args) {
        //doGetMaxNumsInString1();
        doGetMaxNumsInString2();
    }

    public static void doGetMaxNumsInString2() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<String, Integer> map = Maps.newHashMap();
        char[] chars = str.toCharArray();
        String temp = "";
        int count = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i]>='0' && chars[i]<='9') {
                int index = i;
                count = 1;
                for (int j = i+1;j<chars.length; j++) {
                    if (chars[j] >= '0' && chars[j]<='9') {
                        index = j;
                        count++;
                    } else {
                        map.put(str.substring(i, index+1), count);
                        break;
                    }
                }
            } else {
                continue;
            }
        }
        int max  = 0;
        for (String key : map.keySet()) {
            max = map.get(key) > max ? map.get(key) : max;
        }
        System.out.println(max);
    }

    public static void doGetMaxNumsInString1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int count = 0;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i]<='9') {
                int index = i;
                count = 1;
                for (int j = i+1;j<chars.length; j++) {
                    if (chars[j] >= '0' && chars[j]<='9') {
                        count++;
                        index = j;
                    } else {
                        break;
                    }
                }
                if (count > result.length()) {
                    result = str.substring(i, index + 1);
                }
            } else {
                continue;
            }
        }
        System.out.println(result);
    }
}
