package com.ryz2593.happy.study.algorithmbasic;

/**
 * 二分查找
 *
 * @since 2020-05-14
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] srcArray = new int[]{1,2,3,4,5,6,7,8,9};
        int des = 9;
        binarySearch(srcArray, des);
    }

    public static int binarySearch(int[] srcArray, int des) {
        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            int middle = (start + end) >>> 1;
            System.out.println(middle);
            if (des == srcArray[middle]) {
                return middle;
            } else if (des < srcArray[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
