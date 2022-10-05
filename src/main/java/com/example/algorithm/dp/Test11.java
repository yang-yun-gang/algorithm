package com.example.algorithm.dp;

import java.util.Arrays;

/**
 * @Description : 300. 最长递增子序列
 * @Author : young
 * @Date : 2022-09-29 9:22
 * @Version : 1.0
 **/
public class Test11 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int lengthOfLISPlus(int[] nums) {
        // 表示牌堆顶部的牌 有序
        int[] top = new int[nums.length];
        // 牌堆
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 二分查找放在哪个牌堆
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[i]) {
                    right = mid;
                } else if (nums[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 如果没有找到 创建新的牌堆
            if (left == piles) piles++;
            top[piles] = nums[i];
        }

        return piles;
    }
}
