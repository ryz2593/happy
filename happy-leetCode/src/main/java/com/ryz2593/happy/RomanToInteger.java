package com.ryz2593.happy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ryz2593
 * @date 2019/4/2
 * @desc
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("CI"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        int sum = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            char lastChar = s.charAt(i);
            char currentChar = s.charAt(i - 1);

            if ((currentChar == 'I' && (lastChar == 'V' || lastChar == 'X')) ||
                    (currentChar == 'X' && (lastChar == 'L' || lastChar == 'C')) ||
                    (currentChar == 'C' && (lastChar == 'D' || lastChar == 'M'))) {
                sum += romanValues.get(lastChar) - romanValues.get(currentChar);
                i--;
                if (i == 0) {
                    return sum;
                }
            } else {
                sum += romanValues.get(lastChar);
            }
        }
        sum += romanValues.get(s.charAt(0));
        return sum;

    }
}
