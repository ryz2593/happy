package com.ryz2593.happy.nowcoder;

import java.util.Scanner;

/**
 * @autor ryz2593
 * @date 2019/12/29 21:45
 * @desc
 */
public class StringSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strs = new String[num];
        int index = 0;
        while (sc.hasNext() && index < num) {
            String s = sc.nextLine();
            strs[index++] = s;
        }
        for(String s:strs) {
            if (s.length() % 8 != 0) {
                s += "00000000";
            }
            // 如果不是八的倍数，字符串直接加八个“0”，
            // 明显字符串只要八个一组输出就可以啦；
            while (s.length() >= 8) {
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }
    }
}
