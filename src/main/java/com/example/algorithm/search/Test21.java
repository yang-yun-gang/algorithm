package com.example.algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : 994. 腐烂的橘子
 * @Author : young
 * @Date : 2022-08-25 15:06
 * @Version : 1.0
 **/
public class Test21 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 时间
        int time = 0;
        // 新鲜橘子个数
        int cnt = 0;
        // 重点：队列
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 广度遍历框架
        while (cnt > 0 && !queue.isEmpty()) {
            int k = queue.size();
            for (int i = 0; i < k; i++) {
                int[] rot = queue.poll();
                int x = rot[0];
                int y = rot[1];
                // 上
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    cnt--;
                    grid[x - 1][y] = 2;
                    queue.add(new int[]{x - 1, y});
                }
                // 下
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    cnt--;
                    grid[x + 1][y] = 2;
                    queue.add(new int[]{x + 1, y});
                }
                // 左
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    cnt--;
                    grid[x][y - 1] = 2;
                    queue.add(new int[]{x, y - 1});
                }
                // 右
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    cnt--;
                    grid[x][y + 1] = 2;
                    queue.add(new int[]{x, y + 1});
                }
            }
            time++;
        }

        if (cnt == 0) {
            return time;
        } else {
            return -1;
        }
    }
}
