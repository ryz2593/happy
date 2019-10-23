package com.ryz2593.happy;

/**
 * 时间复杂度：O(N2) 　　
 * 稳定性：稳定
 *
 * 依次比较相邻两元素，若前一元素大于后一元素则交换之，直至最后一个元素即为最大；
 * 然后重新从首元素开始重复同样的操作，直至倒数第二个元素即为次大元素；
 * 依次类推。如同水中的气泡，依次将最大或最小元素气泡浮出水面。
 *
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
