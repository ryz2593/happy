package com.ryz2593.happy.nowcoder;

import java.util.Scanner;

/**
 * 统计字符串中大写字母的个数
 *
 * @autor ryz2593
 * @date 2019/12/29 21:28
 * @desc
 */
public class StatiesUpperCharactersInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            int count = 0;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    count++;
                }

            }
            System.out.println(count);
        }

    }
}
