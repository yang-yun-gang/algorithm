package com.example.algorithm.find;

/**
 * @Description : 剑指 Offer 53 - II. 0～n-1 中缺失的数字
 * @Author : young
 * @Date : 2022-08-02 10:41
 * @Version : 1.0
 **/
public class Test04 {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (m == nums[m]) i = m + 1;
            else j = m - 1;
        }

        return j + 1;
    }
}
