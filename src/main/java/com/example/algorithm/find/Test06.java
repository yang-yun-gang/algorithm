package com.example.algorithm.find;

/**
 * @Description : 74. 搜索二维矩阵
 * @Author : young
 * @Date : 2022-08-23 11:26
 * @Version : 1.0
 **/
public class Test06 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // m行n列
        int m = matrix.length, n = matrix[0].length;
        // 先找到行
        int i = 0, j = m - 1;
        int row = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (matrix[mid][0] > target) {
                // mid的首个值大于目标值 直接砍半
                j = mid - 1;
            } else {
                // mid的首个值小于目标值 讨论
                if (matrix[mid][n - 1] >= target) {
                    // 在mid的内部
                    row = mid;
                    break;
                } else {
                    // 没在mid内
                    i = mid + 1;
                }
            }
        }

        // 在从行里面找
        if (row == -1) {
            return false;
        } else {
            return binarySearch(matrix[row], target);
        }
    }

    private boolean binarySearch(int nums[], int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }
}
