package com.ryz2593.happy;

/**
 * @autor ryz2593
 * @date 2019/11/12 21:38
 * @desc
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1,2,23,233,112,3,0,9,8,4};
        insertSort(arr);
        System.out.println(arr);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
