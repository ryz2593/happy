package com.ryz2593.happy;

import java.util.Scanner;

/**
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * @autor ryz2593
 * @date 2019/12/27 21:11
 * @desc
 */
public class StringSplit {

    public static void main(String[] args) {
        doStringSplit();
    }

    /**
     * 处理函数
     */
    public static void doStringSplit() {
        
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int count = 2;
            while (count > 0) {
                String str = sc.nextLine();
                if (str.length() % 8 != 0) {
                    str += "00000000";
                }
                while (str.length() > 8) {
                    System.out.println(str.substring(0, 8));
                    str = str.substring(8);
                }
                count--;
            }

        }

    }
}
