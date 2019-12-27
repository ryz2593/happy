package com.ryz2593.happy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 集五福  10个人最多可以集齐多少套五福
 *
 * @autor ryz2593
 * @date 2019/12/27 21:36
 * @desc
 */
public class Collect5LuckyCharacters {

    public static void main(String[] args) {

        doCollect5LuckyCharacters();
    }

    public static void doCollect5LuckyCharacters() {
        int[] luckyCharacters = new int[5];
        Arrays.fill(luckyCharacters, 0);
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        while (index < 10) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            if (chars.length > 5) {
                Arrays.fill(chars, 5, chars.length - 1, '0');
            }
            if (chars.length < 5) {
                Arrays.fill(chars, chars.length, 4, '0');
            }
            for (int i = 0; i < 5; i++) {
                if (chars[i] == '1') {
                    luckyCharacters[i] += 1;
                }
            }

            index++;
        }

        int min = luckyCharacters[0];
        for (int i = 1; i < luckyCharacters.length; i++) {
            if (luckyCharacters[i] < min) {
                min = luckyCharacters[i];
            }
        }


        System.out.println(min);
    }
}
