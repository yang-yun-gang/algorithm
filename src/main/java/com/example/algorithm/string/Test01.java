package com.example.algorithm.string;

/**
 * @Description : 字符串操作 https://leetcode.cn/leetbook/read/illustration-of-algorithm/58pq8g/
 * @Author : young
 * @Date : 2022-06-14 10:02
 * @Version : 1.0
 **/
public class Test01 {
    public static void main(String[] args) {
        String test = "+";
        System.out.println(strToInt(test));
    }

    public static int strToInt(String str) {
        int bndry = Integer.MAX_VALUE / 10;
        int res = 0;
        // 先找到第一个非空格字符
        int i = 0;
        int len = str.length();
        while (i < len && str.charAt(i) == ' ') i++;

        if (i == len) return 0;
        // 符号位
        int sig = 1;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            i++;
            sig = -1;
        }

        // 第一个非空格字符不为数字
        if (i >= len || str.charAt(i) < 48 || str.charAt(i) > 57) {
            return 0;
        }
        // 继续往下遍历
        int j = i;
        while (j < len && str.charAt(j) >= 48 && str.charAt(j) <= 57) j++;
        // [i, j)之间就是要找的整数
        while (i < j) {
            int num = str.charAt(i) - 48;

            // 判断越界技巧
            if (res > bndry || (res == bndry && num > 7)) {
                res = (sig == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                break;
            }
            res = res * 10 + num;
            i++;
        }
        res *= sig;

        return res;
    }
}
