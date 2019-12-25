package com.ryz2593.happy;

/**
 * @author ryz2593
 */
public class Candy {

    public static void main(String[] args) {
        int[] ratings = {1, 3, 2, 1};
        System.out.println(candy(ratings));
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
