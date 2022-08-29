package com.example.algorithm.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description : 417. 太平洋大西洋水流问题
 * @Author : young
 * @Date : 2022-08-26 10:17
 * @Version : 1.0
 **/
public class Test22 {

    private int[][] heights;
    private boolean[][] pacific;
    private boolean[][] atlantic;
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;

        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        // 先从太平洋开始
        // 从上出发
        for (int j = 0; j < n; j++) {
            //dfs(pacific, 0, j);
            bfs(pacific, 0, j);
        }
        // 从左出发
        for (int i = 0; i < m; i++) {
            //dfs(pacific, i, 0);
            bfs(pacific, i, 0);
        }

        // 然后是大西洋
        // 从下
        for (int j = 0; j < n; j++) {
            //dfs(atlantic, m - 1, j);
            bfs(atlantic, m - 1, j);
        }
        // 从右出发
        for (int i = 0; i < m; i++) {
            //dfs(atlantic, i, n - 1);
            bfs(atlantic, i, n - 1);
        }

        // 最后汇总
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }

        return res;
    }

    // 深度优先
    private void dfs(boolean[][] ocean, int i, int j) {
        if (ocean[i][j]) {
            return;
        }
        ocean[i][j] = true;
        // 上
        if (i - 1 >= 0 && ocean[i - 1][j] == false && heights[i - 1][j] >= heights[i][j]) {
            dfs(ocean,i - 1, j);
        }

        // 下
        if (i + 1 < m && ocean[i + 1][j] == false && heights[i + 1][j] >= heights[i][j]) {
            dfs(ocean,i + 1, j);
        }

        // 左
        if (j - 1 >= 0 && ocean[i][j - 1] == false && heights[i][j - 1] >= heights[i][j]) {
            dfs(ocean, i, j - 1);
        }

        // 右
        if (j + 1 < n && ocean[i][j + 1] == false && heights[i][j + 1] >= heights[i][j]) {
            dfs(ocean, i, j + 1);
        }
    }

    // 广度优先
    private void bfs(boolean[][] ocean, int i, int j) {
        if (ocean[i][j]) {
            return;
        }
        ocean[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];

            // 上
            if (x - 1 >= 0 && ocean[x - 1][y] == false && heights[x - 1][y] >= heights[x][y]) {
                ocean[x - 1][y] = true;
                queue.add(new int[]{x - 1, y});
            }

            // 下
            if (x + 1 < m && ocean[x + 1][y] == false && heights[x + 1][y] >= heights[x][y]) {
                ocean[x + 1][y] = true;
                queue.add(new int[]{x + 1, y});
            }

            // 左
            if (y - 1 >= 0 && ocean[x][y - 1] == false && heights[x][y - 1] >= heights[x][y]) {
                ocean[x][y - 1] = true;
                queue.add(new int[]{x, y - 1});
            }

            // 右
            if (y + 1 < n && ocean[x][y + 1] == false && heights[x][y + 1] >= heights[x][y]) {
                ocean[x][y + 1] = true;
                queue.add(new int[]{x, y + 1});
            }
        }
    }

    public static void main(String[] args) {
        int[][] t = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        Test22 test = new Test22();
        System.out.println(test.pacificAtlantic(t));
    }
}
