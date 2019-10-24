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
     * 冒泡排序算法的算法过程如下：
     *
     * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *
     * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     *
     * ③. 针对所有的元素重复以上的步骤，除了最后一个。
     *
     * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        //外层：需要length-1次循环比较
        for (int i = 0; i < array.length; i++)
            //内层：每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，所以每次比较次数递减一次
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    //交换数组array的j和j+1位置的数据
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
