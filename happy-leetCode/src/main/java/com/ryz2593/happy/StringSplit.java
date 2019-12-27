package com.ryz2593.happy;

import java.util.Scanner;

/**
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * <p>
 * 示例1
 * 输入
 * abc
 * 123456789
 * 输出
 * abc00000
 * 12345678
 * 90000000
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
     * 连续输入字符串(输入2次,每个字符串长度小于100)
     */
    public static void doStringSplit() {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String[] strings = new String[2];
        while (count < 2) {
            String str = sc.nextLine();
            strings[count] = str;
            count++;
        }
        for (String str : strings) {
            //字符串不是8的倍数，直接在后面拼接8个0
            if (str.length() % 8 != 0) {
                str += "00000000";
            }

            //输出
            while (str.length() > 8) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8);
            }
        }
    }
}
