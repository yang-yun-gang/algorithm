package com.example.algorithm.find;

/**
 * @Description : 剑指 Offer 04. 二维数组中的查找
 * @Author : young
 * @Date : 2022-07-30 11:04
 * @Version : 1.0
 **/
public class Test01 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (target < matrix[i][j]) {
                // 往左
                j--;
            } else if (target > matrix[i][j]) {
                // 往右
                i++;
            } else {
                return true;
            }
        }

        return false;
    }
}
