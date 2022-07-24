package com.example.algorithm.dp;

/**
 * @Description : 周赛动态规划 https://leetcode.cn/problems/minimum-path-cost-in-a-grid/
 * @Author : young
 * @Date : 2022-06-15 11:15
 * @Version : 1.0
 **/
public class Test01 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost = new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        System.out.println(minPathCost(grid, moveCost));
    }

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        // m代表行，n代表列
        int m = grid.length, n = grid[0].length;
        // 存放当前行的f[i][j], f[i][j]代表从第一行出发到第i行第j列的最小代价
        int[] f = grid[0];
        // 从第二行开始
        for (int i = 1; i < m; i++) {
            int[] newf = new int[n];
            // 当前f(i, j)从上一行转化而来
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                // 上一行
                for (int k = 0; k < n; k++) {
                    // 状态转移方程
                    min = Math.min(min, f[k] + moveCost[grid[i - 1][k]][j]);
                }
                // 当前行的f
                newf[j] = grid[i][j] + min;
            }

            // 行扫描往下
            f = newf;
        }

        int res = Integer.MAX_VALUE;
        for (int fi : f) {
            res = (fi < res) ? fi : res;
        }

        return res;
    }
}
