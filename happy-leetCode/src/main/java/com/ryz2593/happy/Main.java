package com.ryz2593.happy;

import java.util.Arrays;

/**
 * @autor ryz2593
 * @date 2019/12/25 22:07
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        String[] ar = {"time", "me", "bell"};
        getMinNumLengthOfStringArray(ar);
        System.out.println("------------");
        getMinNumLengthq(ar);
    }

    public static void getMinNumLengthq(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            words[i] = StringReverse(words[i]);
        }
        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            if (i + 1 < words.length && words[i].length() < words[i + 1].length() && words[i].equals(words[i + 1].substring(0, words[i].length()))) {
                continue;
            }
            count += words[i].length() + 1;
        }
        System.out.println(count);
    }

    private static String StringReverse(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        return stringBuilder.reverse().toString();
    }


    private static void getMinNumLengthOfStringArray(String[] array) {
        Arrays.sort(array, (a, b) -> b.length() - a.length());
        String result = "";
        for (int i = 0; i < array.length; i++) {
            int pos = result.indexOf(array[i]);
            if (pos != -1 && result.substring(pos + array[i].length(), pos + array[i].length() + 1).equals("#")) {
                continue;
            } else {
                result += array[i];
                result += "#";
            }
        }
        System.out.println(result);
        System.out.println(result.length());
    }

}