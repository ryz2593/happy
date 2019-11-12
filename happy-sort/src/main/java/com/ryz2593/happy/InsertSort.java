package com.ryz2593.happy;

/**
 * @autor ryz2593
 * @date 2019/11/12 21:38
 * @desc
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1,2,23,-233,112,3,0,9,8,4};
        insertSort(arr);
        System.out.println(arr);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    /**
     * 在要排序的一组数中，假定前n-1个数已经排好序，
     * 现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。
     * 如此反复循环，直到全部排好顺序。
     * @param array
     */
    private static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                   int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
    }


}
