package com.example.algorithm.game;

/**
 * @Description : TODO
 * @Author : young
 * @Date : 2022-06-26 10:31
 * @Version : 1.0
 **/
public class Test01 {
    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j || (i + j == grid.length - 1)) {
                    // 在X上
                    if (grid[i][j] == 0) return false;
                } else {
                    // 在非X上
                    if (grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }
}
