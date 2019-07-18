package com.ryz2593.happy;

import java.util.ArrayList;
import java.util.List;

/**
 *46. Permutations

 Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 *
 * @author ryz2593
 * @date 2019/5/30
 * @desc 全排列， 使用回溯法
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, nums.length, 0, result);
        return result;
    }

    public static void dfs(int[] nums, int n, int index, List<List<Integer>> result) {
        if (index == n - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nums[i]);
            }
            result.add((list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            //交换元素位置
            swap(nums, index, i);
            dfs(nums, n, index + 1, result);
            //回溯
            swap(nums, index, i);
        }
    }
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        List<List<Integer>> result = permute(arr);
        System.out.println(result.size());
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }

    }
}
