package com.example.algorithm.dp;

/**
 * @Description : 最长回文子串
 * @Author : young
 * @Date : 2022-07-20 8:45
 * @Version : 1.0
 **/
public class Test08 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        boolean[][] p = new boolean[len][len];
        // 单个字符为回文串
        for (int i = 0; i < len; i++) {
            p[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;
        // 范围扩大
        for (int l = 2; l <= len; l++) {
            // 左边界
            for (int i = 0; i < len; i++) {
                // 右边界
                int j = l + i - 1;
                if (j >= len) break;

                if (chars[i] != chars[j]) {
                    p[i][j] = false;
                } else {
                    if (l == 2) {
                        p[i][j] = true;
                    } else {
                        p[i][j] = p[i + 1][j - 1];
                    }
                }

                if (p[i][j] && l > maxLen) {
                    maxLen = l;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Test08 test = new Test08();
        System.out.println(test.longestPalindrome("bb"));
    }
}
