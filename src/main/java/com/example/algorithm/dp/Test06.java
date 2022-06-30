package com.example.algorithm.dp;

/**
 * @Description : 剑指 Offer 47. 礼物的最大价值
 * @Author : young
 * @Date : 2022-06-30 10:30
 * @Version : 1.0
 **/
public class Test06 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // int[][] f = new int[m][n]; 原地修改grid 将空间复杂度将为1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = (j - 1 < 0) ? 0 : grid[i][j - 1];
                int upper = (i - 1 < 0) ? 0 : grid[i - 1][j];

                grid[i][j] = Math.max(left, upper) + grid[i][j];
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Test06 test = new Test06();
        System.out.println(test.maxValue(grid));
    }
}
