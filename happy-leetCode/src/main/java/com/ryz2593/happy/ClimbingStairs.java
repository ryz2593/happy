package com.ryz2593.happy;

/**
 *
 * 70. Climbing Stairs

 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 Example 1:

 Input: 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step

 * @author ryz2593
 * @date 2019/6/3
 * @desc
 */
public class ClimbingStairs {

    /**
     * 当n较大时，耗时超过题目要求
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n -2);
        }
    }

    public static int climbStairs2(int n) {
        return climb_Stairs(0, n);
    }

    /**
     * 当n较大时，耗时超过题目要求
     */
    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }


    /**
     * 时间复杂度满足题目要求
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(climbStairs(38));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("=========================");
        long start2 = System.currentTimeMillis();
        System.out.println(climbStairs2(38));
        System.out.println(System.currentTimeMillis() - start2);

        System.out.println("=========================");
        long start3 = System.currentTimeMillis();
        System.out.println(climbStairs3(38));
        System.out.println(System.currentTimeMillis() - start3);
    }
}
