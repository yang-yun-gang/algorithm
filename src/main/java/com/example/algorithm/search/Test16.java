package com.example.algorithm.search;

/**
 * @Description : 1706. 球会落何处
 * @Author : young
 * @Date : 2022-08-10 9:09
 * @Version : 1.0
 **/
public class Test16 {

    private int[][] grid;
    private int m;
    private int n;

    public int[] findBall(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            res[j] = dfs(0, j);
        }

        return res;
    }

    private int dfs(int i, int j) {
        if (i >= m) {
            return j;
        }
        if (grid[i][j] == 1) {
            // 检查右边邻居
            if (j + 1 >= n || grid[i][j + 1] == -1) {
                return -1;
            }
            // 球往下移动
            return dfs(i + 1, j + 1);
        } else {
            // 检查左边邻居
            if (j - 1 < 0 || grid[i][j - 1] == 1) {
                return -1;
            }
            // 球往下移动
            return dfs(i + 1, j - 1);
        }
    }
}
