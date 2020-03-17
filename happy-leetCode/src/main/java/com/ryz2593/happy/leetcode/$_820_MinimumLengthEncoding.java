package com.ryz2593.happy.leetcode;
import java.util.Arrays;

/**
 * 820. 单词的压缩编码
 * @since 2019-10-23
 */
public class $_820_MinimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b)->b.length() - a.length());
        String res = "";
        for (int i = 0; i < words.length; i++) {
            int index = res.indexOf(words[i]);
            if (index != -1 && res.substring(index + words[i].length(), index + words[i].length() + 1).equals("#")) {
                continue;
            } else {
                res = res + words[i];
                res = res + "#";
            }
        }
        return res.length();
    }

    public static void main(String[] args) {
        $_820_MinimumLengthEncoding ins = new $_820_MinimumLengthEncoding();
        String[] param1 = new String[] {"time", "me", "bell"};
        System.out.println(ins.minimumLengthEncoding(param1));
        String[] param2 = new String[] {"me", "time"};
        System.out.println(ins.minimumLengthEncoding(param2));
        String[] param3 = new String[] {"me", "time","member","bell","bear", "bee"};
        System.out.println(ins.minimumLengthEncoding(param3));
    }
}
