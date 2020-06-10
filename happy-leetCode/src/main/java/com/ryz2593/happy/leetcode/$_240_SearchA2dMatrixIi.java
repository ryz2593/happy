//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
//
//
// 每行的元素从左到右升序排列。
// 每列的元素从上到下升序排列。
//
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
// Related Topics 二分查找 分治算法

package com.ryz2593.happy.leetcode;

/**
 * 功能描述
 *
 * @author r30002879
 * @since 2020-06-09
 */
public class $_240_SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new $_240_SearchA2dMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // start our "pointer" in the bottom-left
            int row = matrix.length - 1;
            int col = 0;

            while (row >= 0 && col < matrix[0].length) {
                if (matrix[row][col] > target) {
                    row--;
                } else if (matrix[row][col] < target) {
                    col++;
                } else { // found it
                    return true;
                }
            }

            return false;
        }


//        public boolean searchMatrix(int[][] matrix, int target) {
//            if (matrix == null || matrix.length == 0) {
//                return false;
//            }
//            int shorterDim = Math.min(matrix.length, matrix[0].length);
//            for (int i = 0; i < shorterDim; i++) {
//                boolean verticalFound = binarySearch(matrix, target, i, true);
//                boolean horizontalFound = binarySearch(matrix, target, i, false);
//                if (verticalFound || horizontalFound) {
//                    return true;
//                }
//            }
//
//            return false;
//        }
//
//        public boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
//            int lo = start;
//            int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;
//            while (hi >= lo) {
//                int middle = (lo + hi) / 2;
//                if (vertical) {
//                    if (matrix[start][middle] == target) {
//                        return true;
//                    } else if (matrix[start][middle] < target) {
//                        lo = middle + 1;
//                    } else {
//                        hi = middle - 1;
//                    }
//                } else {
//                    if (matrix[middle][start] == target) {
//                        return true;
//                    } else if (matrix[middle][start] < target) {
//                        lo = middle + 1;
//                    } else {
//                        hi = middle - 1;
//                    }
//                }
//            }
//            return false;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
