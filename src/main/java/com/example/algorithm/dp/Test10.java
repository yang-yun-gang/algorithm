package com.example.algorithm.dp;

import java.util.Arrays;

/**
 * @Description : 322. 零钱兑换
 * @Author : young
 * @Date : 2022-09-01 11:40
 * @Version : 1.0
 **/
// dfs
public class Test10 {
    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount];
        return dfs(coins, amount);
    }

    // 找到amount数量的零钱可以兑换的最少硬币数量
    private int dfs(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 剪枝
        if (memo[amount-1] != 0) {
            return memo[amount - 1];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int t = dfs(coins, amount - coins[i]);
            // 如果不为-1，才更新res
            if (t >= 0) {
                res = Math.min(res, t + 1);
            }
        }

        // 记到备忘录
        memo[amount - 1] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount - 1];
    }
}

// 动态规划（自顶向下）
class DP1 {
    int[] coins;
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new int[amount + 1];

        int res = dp(amount);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;

    }

    // dp(x)表示凑出x的最小硬币数
    private int dp(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        // 剪枝
        if (memo[amount] != 0) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        // 选择需要硬币最少的
        for (int i = 0; i < coins.length; i++) {
            // 子问题的解
            int subRes = dp(amount - coins[i]);
            // 子问题无解 跳过
            if (subRes == -1) continue;
            res = Math.min(subRes + 1, res);
        }

        res = (res == Integer.MAX_VALUE) ? -1 : res;

        memo[amount] = res;

        return res;
    }
}

// 动态规划（自底向上）
class DP2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 最大为amount个硬币
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 外层遍历所有状态取值
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
