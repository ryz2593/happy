package com.ryz2593.happy;

import java.util.Arrays;

/**
 * @author ryz2593
 */
public class Candy {

    public static void main(String[] args) {
        int[] ratings = {1, 3, 2, 1,4,3,1};
        System.out.println(candy(ratings));
        System.out.println(candySolutionWith2Array(ratings));
    }

    /**
     * 使用两个数组来计算
     * @param ratings
     * @return
     */
    public static int candySolutionWith2Array(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1]) {
                left2right[i] = left2right[i-1]+1;
            }
        }
        for (int length = ratings.length-2; length > 0; length--) {
            if (ratings[length]>ratings[length+1]){
                right2left[length] = right2left[length+1] + 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }

    public static int candySolution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                if (countDown > 0) {
                    total += countDown * (countDown + 1) / 2;
                    if (countDown >= prev) {
                        total += countDown - prev + 1;
                    }
                    countDown = 0;
                    prev = 1;
                }
                prev = arr[i] == arr[i - 1] ? 1 : prev + 1;
                total += prev;
            } else {
                countDown++;
            }

        }
        if (countDown > 0) {
            total += countDown * (countDown + 1) / 2;
            if (countDown >= prev) {
                total += countDown - prev + 1;
            }
        }
        return total;
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (countDown > 0) {
                    total += countDown * (countDown + 1) / 2; // arithmetic progression
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                total += prev;
            } else countDown++;
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown * (countDown + 1) / 2;
            if (countDown >= prev) total += countDown - prev + 1;
        }
        return total;
    }
}
