package com.ryz2593.happy;

import java.util.Arrays;

/**
 * 时间复杂度：O(NlogN) 　　
 * 稳定性：稳定
 *
 * 和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。
 * 代价是需要额外的内存空间。
 * 归并排序是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * @author ryz2593
 * @date 2019/7/22
 * @desc
 */
public class MergeSort {
    public static int[] MergeSort(int[] array) {
        if(array.length<2) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }


    /**
     *
     * 将两段排序好的数组结合成一个排序数组
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int result[] = new int[left.length+ right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if(left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {23,2,15,60,40};
        System.out.println(MergeSort(array));
        int[] result = MergeSort(array);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }
}
