package com.ryz2593.happy.nowcoder;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 示例1
 * 输入
 * hello world
 * 输出
 * 5
 *
 * @autor ryz2593
 * @date 2019/12/29 20:51
 * @desc
 */
public class LengthOfLastWordInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int lastWordLength = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                break;
            }
            lastWordLength++;
        }

        System.out.println(lastWordLength);
    }
}
