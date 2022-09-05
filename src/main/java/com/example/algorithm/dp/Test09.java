package com.example.algorithm.dp;

/**
 * @Description : 198.打家劫舍
 * @Author : young
 * @Date : 2022-08-30 16:37
 * @Version : 1.0
 **/
public class Test09 {
    // 自己的动态规划方程
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(nums[0] + nums[2], nums[1]);

        int p = 3;
        while (p < n) {
            dp[p] = Math.max(dp[p - 2], dp[p - 3]) + nums[p];
            // 向前滚动
            p++;
        }

        int res = 0;
        for (int k : dp) {
            res = Math.max(k, res);
        }
        return res;
    }

    // 官方答案
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // 表示从第k个房子中能偷到的最大金额
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        int k = 2;
        while (k <= n) {
            // 状态转移方程 注意nums的下标
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k - 1]);
            k++;
        }

        return dp[n];
    }
}
