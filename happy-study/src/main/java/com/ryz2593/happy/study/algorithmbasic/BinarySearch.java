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
        //定义最小，最大索引
        int start = 0;
        int end = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (start <= end) {
            //计算出中间索引值
            int middle = (start + end) >>> 1;//防止溢出
            System.out.println(middle);
            if (des == srcArray[middle]) {
                return middle;
            //判断下限
            } else if (des < srcArray[middle]) {
                end = middle - 1;
            //判断上限
            } else {
                start = middle + 1;
            }
        }
        //若没有查到，则返回-1
        return -1;
    }
}
