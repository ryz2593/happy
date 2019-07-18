package com.ryz2593.happy;

import java.math.BigInteger;

/**
 *
 * 67. Add Binary

 Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 *
 * @author ryz2593
 * @date 2019/6/4
 * @desc
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        return (new BigInteger(a, 2)).add(new BigInteger(b, 2)).toString(2);
    }

    public static void main(String[] args) {
        String a = "1110";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}
