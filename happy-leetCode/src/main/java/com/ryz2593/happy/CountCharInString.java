package com.ryz2593.happy;

import java.util.Scanner;


/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class CountCharInString {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        Character c =  scanner.nextLine().charAt(0);
        Character.toLowerCase(c);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==c) {
                count++;
            }
        }
        System.out.println(count);
    }
}
