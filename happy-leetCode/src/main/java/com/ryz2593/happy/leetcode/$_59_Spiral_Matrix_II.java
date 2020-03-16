package com.ryz2593.happy.leetcode;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2(n的平方)所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author ryz2593
 * @date 2020/3/16 15:42
 */
public class $_59_Spiral_Matrix_II {

    public static void main(String[] args) {
        int n = 4;
        int[][] ints = solve(n);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) {
                // left to right.
                mat[t][i] = num++;
            }
            t++;
            for(int i = t; i <= b; i++) {
                // top to bottom.
                mat[i][r] = num++;
            }
            r--;
            for(int i = r; i >= l; i--) {
                // right to left.
                mat[b][i] = num++;
            }
            b--;
            for(int i = b; i >= t; i--) {
                // bottom to top.
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;

    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int begin = 1, j = 0;
        while (begin <= Math.pow(n, 2)) {
            for (int i = j; i < n - j; i++) {
                result[j][i] = begin++;
            }
            for (int i = j + 1; i < n - j; i++) {
                result[i][n - j - 1] = begin++;
            }
            for (int i = n - j - 2; i >= j; i--) {
                result[n - j - 1][i] = begin++;
            }
            for (int i = n - j - 2; i > j; i--) {
                result[i][j] = begin++;
            }

            j++;
        }

        return result;
    }
}
