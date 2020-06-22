//84
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
// 示例:
//
// 输入: [2,1,5,6,2,3]
//输出: 10
// Related Topics 栈 数组

package com.ryz2593.happy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class $_84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new $_84_LargestRectangleInHistogram().new Solution();
        int[] heights = {2, 1, 2};
        System.out.println(solution.largestRectangleArea3(heights));
        System.out.println(solution.largestRectangleArea4(heights));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int largestRectangleArea4(int[] heights) {
            int maxArea = Integer.MIN_VALUE;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[i] < stack.peek()) {
                    Integer top = stack.pop();
                    int width = i - stack.peek() - 1;
                    maxArea = Math.max(maxArea,  width* heights[top]);
                }
                stack.push(i);
            }
            while (stack.peek() != -1) {
                int area = heights[stack.pop()] * (heights.length - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }

        public int largestRectangleArea(int[] heights) {
            if (heights.length <= 0 || heights == null) {
                return 0;
            }
            int area = heights[0];
            for (int i = 0; i < heights.length; i++) {
                int wide = 1;
                while (i > 0) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (heights[j] < heights[i]) {
                            break;
                        } else {
                            wide++;
                        }
                    }
                    break;
                }
                for (int j = i + 1; j < heights.length; j++) {
                    if (heights[j] < heights[i]) {
                        break;
                    } else {
                        wide++;
                    }
                }
                area = wide * heights[i] > area ? wide * heights[i] : area;
            }
            return area;
        }

        /**
         * 暴力解法 会超时
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea2(int[] heights) {
            if (heights.length == 0) {
                return 0;
            }
            int maxArea = Integer.MIN_VALUE;
            for (int i = 0; i < heights.length; i++) {
                for (int j = i; j < heights.length; j++) {
                    int minHeight = Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        minHeight = Math.min(heights[k], minHeight);
                    }
                    maxArea = Math.max(maxArea, (j-i+1)*minHeight);
                }
            }
            return maxArea;
        }


        /**
         * 使用单调栈实现
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea3(int[] heights) {
            if (heights.length == 0) {
                return 0;
            }
            int maxArea = Integer.MIN_VALUE;
            Deque<Integer> stack = new ArrayDeque<>();
            //放置一个冗余元素方便计算
            stack.push(-1);
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    int top = stack.pop();
                    int width = i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, heights[top] * width);
                }
                stack.push(i);
            }
            while (stack.peek() != -1) {
                int area = heights[stack.pop()] * (heights.length - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            return maxArea;
        }
    }

}
