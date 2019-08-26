package com.ryz2593.happy;

/**
 * @autor ryz2593
 * @date 2019/8/26 22:29
 * @desc
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1,2,30,18,25,40,6,12};
        int[] selectionSort = selectionSort(arr);
        for (int i : selectionSort) {
            System.out.print(i + " ");
        }
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
