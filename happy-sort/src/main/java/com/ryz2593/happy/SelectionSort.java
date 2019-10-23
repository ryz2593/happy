package com.ryz2593.happy;

/**
 * 时间复杂度：O(N2) 　　
 * 稳定性：不稳定
 *
 * 首先初始化最小元素索引值为首元素，依次遍历待排序数列，若遇到小于该最小索引位置处的元素则刷新最小索引为该较小元素的位置，
 * 直至遇到尾元素，结束一次遍历，并将最小索引处元素与首元素交换；然后，初始化最小索引值为第二个待排序数列元素位置，
 * 同样的操作，可得到数列第二个元素即为次小元素；以此类推
 *
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
