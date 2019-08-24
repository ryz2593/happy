package com.ryz2593.happy;

/**
 * @autor ryz2593
 * @date 2019/8/24 21:48
 * @desc
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,30,18,25,40,6,12};
        int[] bubbleSort = bubbleSort(arr);
        for (int i : bubbleSort) {
            System.out.print(i + " ");
        }
    }
}
