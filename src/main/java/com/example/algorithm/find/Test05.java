package com.example.algorithm.find;

/**
 * @Description : 33. 搜索旋转排序数组
 * @Author : young
 * @Date : 2022-08-23 10:28
 * @Version : 1.0
 **/
public class Test05 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                // 左边有序
                if (target >= nums[l] && target < nums[mid]) {
                    // 在左边
                    r = mid - 1;
                } else {
                    // 在右边
                    l = mid + 1;
                }
            } else {
                // 右边有序
                if (target > nums[mid] && target <= nums[r]) {
                    // 在右边
                    l = mid + 1;
                } else {
                    // 在左边
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

}
