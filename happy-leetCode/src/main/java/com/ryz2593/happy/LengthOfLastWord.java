package com.ryz2593.happy;

/**
 *
 * 58. Length of Last Word

 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Input: "Hello World"
 Output: 5
 * @author ryz2593
 * @date 2019/6/3
 * @desc
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s.trim() == "") {
            return 0;
        }
        String[] strArr = s.trim().split(" ");
        String lastWord = strArr[strArr.length - 1];
        return lastWord.length();
    }

    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }
        return length;
    }

    public static int lengthOfLastWord3(String s) {
        s = s.trim();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (alphabet.indexOf(Character.toLowerCase(s.charAt(i))) != -1) {
                r++;
            } else {
                return r;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord2(s));
        System.out.println(lengthOfLastWord3(s));
    }
}
