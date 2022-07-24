package com.example.algorithm.game;

/**
 * @Description : 周赛303 相等行列对
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * @Author : young
 * @Date : 2022-07-24 10:48
 * @Version : 1.0
 **/
public class Test08 {
    public int equalPairs(int[][] grid) {
        int res = 0;

        int n = grid.length;

        // 遍历每一行 每一行在去遍历每一列
        // 第i行
        for (int i = 0; i < n; i++) {
            // 第j列
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }
            }
        }

        return res;
    }
}
