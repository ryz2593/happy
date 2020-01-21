package com.ryz2593.happy.study.algorithmbasic.backtracking;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ryz
 * @Date: 2020/1/14 22:27
 */
public class NQueens {

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("-----------------------------------");
        }
        System.out.println(lists.size());
    }


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = -1;
        }
        backtrace(board, 0, lists, queens);
        return lists;
    }

    /**
     * 回溯尝试放置皇后
     *
     * @param board  棋盘
     * @param x      行索引
     * @param lists  有效解的集合
     * @param queens 已放置的皇后
     */
    private static void backtrace(char[][] board, int x, List<List<String>> lists, int[] queens) {
        if (x == board.length) {
            // 有效解
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            lists.add(list);
            return;
        }
        for (int y = 0; y < board.length; y++) {
            if (validate(board, x, y, queens)) {
                // 尝试放置皇后
                board[x][y] = 'Q';
                queens[x] = y;
                // 尝试下一行
                backtrace(board, x + 1, lists, queens);
                // 撤销前一次的尝试
                board[x][y] = '.';
                queens[x] = -1;
            }
        }
    }

    /**
     * 检查能否放置皇后
     *
     * @param board  棋盘
     * @param x,y    待放置皇后的坐标
     * @param queens 已放置的皇后
     * @return true-可放置，false-不可放置
     */
    private static boolean validate(char[][] board, int x, int y, int[] queens) {
        if (y == board.length) {
            return false;
        }
        // 利用两点式直线方程，验证已放置的皇后是否在待放置点（x, y）的两条斜线上
        int dx, dy;
        for (int qx = 0; qx < x; qx++) {
            dy = y - queens[qx];
            if (dy == 0) {
                // 在同一列上有王后
                return false;
            }
            dx = x - qx;
            if (dx == dy || dx == -dy) {
                // 斜率为1或-1时，在斜线上有王后
                return false;
            }
        }
        return true;
    }

}
