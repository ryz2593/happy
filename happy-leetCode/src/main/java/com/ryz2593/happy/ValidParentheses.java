package com.ryz2593.happy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 *
 * @author ryz2593
 * @date 2019/4/16
 * @desc
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String str = "(]";
        boolean valid = isValid(str);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                characterStack.push(chars[i]);
            }
            if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                if (characterStack.empty()) {
                    return false;
                }
                Character character = characterStack.pop();
                switch (character) {
                    case '(':
                        if (chars[i] != ')') {
                            return false;
                        }
                        break;
                    case '{':
                        if (chars[i] != '}') {
                            return false;
                        }
                        break;
                    case '[':
                        if (chars[i] != ']') {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        if (!characterStack.empty()) {
            return false;
        }
        return true;
    }
}
