package com.ryz2593.happy;

/**
 *
 * 35. Search Insert Position

 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 4:

 Input: [1,3,5,6], 0
 Output: 0
 *
 * @author ryz2593
 * @date 2019/6/3
 * @desc
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        if (nums[0] > target) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;
        int pos = -1;


        while (low <= high) {
            int middle = (high + low) >>> 1;
            int distance = nums[middle] - target;
            if (distance == 0) {
                return middle;
            } else if (distance > 0) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            if (distance > 0) {
                pos = middle;
            }
        }
        return pos;
    }



    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
