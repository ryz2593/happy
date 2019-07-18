package com.ryz2593.happy;

/**
 * 28. Implement strStr()
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * @author ryz2593
 * @date 2019/5/30
 * @desc
 */
public class NeedleInHaystack {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        } else if (haystack.length() == 0) {
            return -1;
        } else {
            return haystack.indexOf(needle);
        }
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }
}
