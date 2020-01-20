package com.ryz2593.happy.study.algorithmbasic.backtracking;

import java.util.ArrayList;

/**
 * @author ryz2593
 * @date 2020/1/20 13:44
 */
public class BackTracking {
    public static void main(String[] args) {
        int n = 3;
        int leftNum = n, rightNum = n;//左括号和右括号都各有n个
        ArrayList<String> results = new ArrayList<String>();//用于存放解空间
        parentheses("", results, leftNum, rightNum);
        for (String s : results) {
            System.out.println(s);
        }


        String s = "abc";
        PermutationAndCombination(s, "");
    }

    public static void parentheses(String sublist, ArrayList<String> results, int leftnum, int rightnum) {
        if (leftnum == 0 && rightnum == 0)//结束
        {
            results.add(sublist);
        }
        if (rightnum > leftnum)//选择和条件。对于不同的if顺序，输出的结果顺序是不一样的，但是构成一样的解空间
        {
            parentheses(sublist + ")", results, leftnum, rightnum - 1);
        }
        if (leftnum > 0) {
            parentheses(sublist + "(", results, leftnum - 1, rightnum);
        }
    }


    /**
     * 字母排列
     * @param s
     * @param temp
     */
    public static void PermutationAndCombination(String s, String temp) {//参数设计地尽量地简洁
        if (s.length() == 0) {
            System.out.println(temp);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String news = s.substring(0, i) + s.substring(i + 1, s.length());//去掉String中的某个字母
            PermutationAndCombination(news, temp + s.charAt(i));
        }
    }
}
