package com.ryz2593.happy.leetcode;
import java.util.Stack;

public class $_316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new $_316_RemoveDuplicateLetters().new Solution();
        System.out.println(solution.removeDuplicateLetters("bbcaacb"));
    }

    class Solution {
        public String removeDuplicateLetters(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < chars.length; i++) {
                if (stack.contains(chars[i])) {
                    continue;
                }
                while (!stack.isEmpty() && chars[i] < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                    stack.pop();
                }
                stack.push(chars[i]);
            }
            char[] result = new char[stack.size()];
            for (int i = 0; i < stack.size(); i++) {
                result[i] = stack.get(i);
            }
            return new String(result);
        }
    }

}
