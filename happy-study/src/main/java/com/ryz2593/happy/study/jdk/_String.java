package com.ryz2593.happy.study.jdk;

/**
 * @author ryz2593
 * @date 2020/3/18 16:08
 */
public class _String {
    public static void main(String[] args) {
        String string = "asdfasdf";

        System.out.println(string);
        String anotherString = "asdfasdf";
        System.out.println(string.equals(anotherString));

        System.out.println(string.contentEquals(anotherString));

        System.out.println(string.compareTo(anotherString));

        System.out.println(string.regionMatches(0, anotherString, 3, 3));

        System.out.println(string.startsWith("a", 4));

        System.out.println(string.hashCode());

        System.out.println(anotherString.hashCode());


    }
}
