package com.example.algorithm.dp;

/**
 * @Description : 剑指 Offer 10- II. 青蛙跳台阶问题
 * @Author : young
 * @Date : 2022-06-28 10:26
 * @Version : 1.0
 **/
public class Test03 {
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        // 从2开始滚动
        int a = 1, b = 1, k = 2;
        while (k++ <= n) {
            int c = b;
            b = (b + a) % 1000000007;
            a = c;
        }

        return b;
    }

    public static void main(String[] args) {
        Test03 test = new Test03();
        System.out.println(test.numWays(44));
    }
}
