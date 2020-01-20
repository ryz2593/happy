package com.ryz2593.happy.study.algorithmbasic.backtracking;

/**
 * 给出一个不重复大于0数字的数组和一个目标，求数组中数的组合的和得到该目标（数字不同组合顺序当做一个解）
 * @author ryz2593
 * @date 2020/1/20 13:55
 */
public class NumSum {
    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 7, 6};
        int target = 9;
        find(num, target, "");
    }

    public static void find(int[] num, int target, String temp) {
        if (issolution(temp, target)) {
            System.out.println(temp);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] != -1) {//如果取过这个数字了，就置为-1
                int k = num[i];
                num[i] = -1;
                find(num, target, temp + k);
                num[i] = k;
            }
        }
    }

    public static boolean issolution(String temp, int target) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < temp.length(); i++) {
            count = count + Integer.valueOf(temp.charAt(i) + "");
        }
        if (count == target) {
            result = true;
        }
        return result;
    }
}
