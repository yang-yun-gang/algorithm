package com.example.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 54. 螺旋矩阵 https://leetcode.cn/problems/spiral-matrix/
 * @Author : young
 * @Date : 2022-07-29 8:40
 * @Version : 1.0
 **/
public class Test02 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        while (i <= m && j <= n) {
            // 从左到右
            for (int k = j; k <= n; k++) {
                res.add(matrix[i][k]);
            }

            // 从上到下
            for (int k = i + 1; k <= m; k++) {
                res.add(matrix[k][n]);
            }

            // 从右到左
            for (int k = n - 1; k >= j && i != m; k--) {
                res.add(matrix[m][k]);
            }

            // 从下到上
            for (int k = m - 1; k > i && j != n; k--) {
                res.add(matrix[k][j]);
            }

            i++;
            j++;
            m--;
            n--;
        }

        return res;
    }


}
