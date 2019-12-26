package com.ryz2593.happy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 820
 *
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * @author ryz2593
 */
public class WordsMinimumLengthEncoding {

    public static void main(String[] args) {
        String[] words = {"time","me","bell"};
        long start = System.currentTimeMillis();
        System.out.println(minimumLengthEncoding(words));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("---------------------------");
        long start2 = System.currentTimeMillis();
        System.out.println(minimumLengthEncoding2(words));
        System.out.println(System.currentTimeMillis() - start2);
    }

    public static int minimumLengthEncoding(String[] words) {
        Set<String> stringSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                stringSet.remove(word.substring(i));
            }
        }
        int count = 0;
        for (String s : stringSet) {
            count += s.length() + 1;
        }
        return count;
    }


    public static int minimumLengthEncoding2(String[] words) {
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

}
