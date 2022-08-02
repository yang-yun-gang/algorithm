package com.example.algorithm.find;

/**
 * @Description : 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @Author : young
 * @Date : 2022-08-01 9:32
 * @Version : 1.0
 **/
public class Test03 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // 寻找右边界
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        int right = l;

        // 寻找左边界
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        int left = r;

        return right - left - 1;

    }
}
