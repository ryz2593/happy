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
        //使用一个boolean数组记录当前每个人是否还在游戏中
        boolean[] arr = new boolean[n];

        //初始值所有人都在游戏中，都设置为true
        Arrays.fill(arr, true);
        //记录游戏中剩余人数
        int count = n;
        //记录有没有数到几了，有没有数到3呢
        int num = 0;
        //记录循环开始位置
        int start = 0;
        //当剩余记录还大于1时，循环
        while (count > 1) {
            //该位置的人还未出局
            if (arr[start]) {
                //判断到这个人的时候有没有数到3
                //如果已经数到3了
                if (num + 1 == 3) {
                    //将游戏总人数减一
                    count--;
                    //报数清零
                    num = 0;
                    //将当前位置的人状态设置为出局
                    arr[start] = false;
                    //打印一下出局的人的顺序
                    System.out.print((start + 1)+ ",");
                    //判断循环有没有到队尾
                    //如果已经到队尾，则设置再比较的起始位置到队头
                    if (start == n - 1) {
                        start = 0;
                    } else{
                        //循环还没有到队尾，下次比较设置到后一位
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
