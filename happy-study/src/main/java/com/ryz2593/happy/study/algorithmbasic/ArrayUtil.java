package com.ryz2593.happy.study.algorithmbasic;

import com.google.common.collect.Lists;

import java.util.List;

public class ArrayUtil {
    public static void main(String[] args) {
        List<Integer> arrays = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);
        print(arrays, 6);
    }

    public static void print(List<Integer> array, int count) {
        List<Integer> ar = Lists.newArrayList();

        for (int i = 0; i < array.size(); i++) {
            int n = i % count;
            ar.add(n, array.get(i));
            while ((i+1) % count  == 0 || i == array.size() - 1) {
                for (int i1 : ar) {
                    System.out.print(i1 + ",");
                }
                System.out.println();
                ar.clear();
                break;
            }
        }
//        for (int i1 : ar) {
//            System.out.print(i1 + ",");
//        }
//        System.out.println();
    }
}
