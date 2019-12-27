package com.ryz2593.happy;

import java.util.Arrays;

/**
 * 报数游戏
 * 一圈人报数，数到3退出，找到最后剩下的人
 * @autor ryz2593
 * @date 2019/12/27 23:40
 * @desc
 */
public class CountingGame {

    public static void main(String[] args) {
        doCountingGame(10);
    }

    public static void doCountingGame(int n) {
        boolean[] arr = new boolean[n];


        Arrays.fill(arr, true);
        //记录剩余个数
        int count = n;
        //记录有没有数到几了，有没有数到3呢
        int num = 0;
        //记录循环开始位置
        int start = 0;
        //当剩余记录还大于1时，循环
        while (count > 1) {
            if (arr[start]) {
                if (num + 1 == 3) {
                    count--;
                    num = 0;
                    arr[start] = false;
                    System.out.print((start + 1)+ ",");
                    if (start == n - 1) {
                        start = 0;
                    } else{
                        start++;
                    }

                } else {
                    num++;
                    if (start == n - 1) {
                        start = 0;
                    } else{
                        start++;
                    }
                }
            } else {
                if (start == n - 1) {
                    start = 0;
                } else{
                    start++;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                System.out.println(i + 1);
            }
        }
    }
}
