package com.example.algorithm.dp;

/**
 * @Description : 516. 最长回文子序列
 * @Author : young
 * @Date : 2022-10-05 11:18
 * @Version : 1.0
 **/
public class Test13 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        // dp[i][j]表示s[i...j]的最长子序列长度
        int[][] dp = new int[len][len];
        // 对角线全为1
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
