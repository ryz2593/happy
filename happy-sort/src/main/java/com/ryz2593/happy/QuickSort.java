package com.ryz2593.happy;

import java.util.Arrays;

/**
 * 时间复杂度：O(NlogN) 　　
 * 稳定性：不稳定
 *
 *  （类似于选择排序的定位思想）选一基准元素，依次将剩余元素中小于该基准元素的值放置其左侧，
 *  大于等于该基准元素的值放置其右侧；然后，取基准元素的前半部分和后半部分分别进行同样的处理；
 *  以此类推，直至各子序列剩余一个元素时，即排序完成（类比二叉树的思想，from up to down）
 *
 * @autor ryz2593
 * @date 2019/8/24 15:46
 * @desc
 */
public class QuickSort
{
    public static void main(String args[])
    {
        QuickSort quicksort = new QuickSort();
        int[] arrays = new int[]
                { 1, 12, 2, 13, 3, 14, 4, 15, 5, 16, 17, 17, 177, 18, 8, 8, 19 };
        quicksort.quickSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private void quickSort(int[] arrays)
    {
        subQuickSort(arrays, 0, arrays.length - 1);
    }

    private void subQuickSort(int[] arrays, int start, int end)
    {
        if (start >= end)
        {
            return;
        }
        int middleIndex = subQuickSortCore(arrays, start, end);
        subQuickSort(arrays, start, middleIndex - 1);
        subQuickSort(arrays, middleIndex + 1, end);
    }

    private int subQuickSortCore(int[] arrays, int start, int end)
    {
        int middleValue = arrays[start];
        while (start < end)
        {
            while (arrays[end] >= middleValue && start < end)
            {
                end--;
            }
            arrays[start] = arrays[end];
            while (arrays[start] <= middleValue && start < end)
            {
                start++;
            }
            arrays[end] = arrays[start];
        }
        arrays[start] = middleValue;
        return start;
    }
}