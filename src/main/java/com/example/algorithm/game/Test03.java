package com.example.algorithm.game;

import java.util.Scanner;

/**
 * @Description : 蔚来 对一个数进行如下操作，乘以x，或乘以y，问最少经过多少次操作，把a变成b
 * @Author : young
 * @Date : 2022-07-15 9:00
 * @Version : 1.0
 **/
public class Test03 {
    private static int res = Integer.MAX_VALUE;
    private static boolean flag = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 用long防止溢出
        long x = sc.nextInt(), y = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        // 先乘较大的数
        if (x >= y) {
            dfs(x, y, a, b, 0);
        } else {
            dfs(y, x, a, b, 0);
        }

        if (res == Integer.MAX_VALUE) {
            // 没找到
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    private static void dfs(long x, long y, long a, long b, int step) {

        // 已经找到解了
        if (flag) {
            return;
        }

        // 没有找到解 停止搜索
        if (a > b) return;

        // 找到解，计算到该解的步数
        if (a == b) {
            res = step;
            flag = true; // 这是由于我们从最大数开始，所以第一个找到的必为最优解
            return;
        }

        // 尝试乘x
        dfs(x, y, a * x, b, step + 1);
        // 尝试乘y
        dfs(x, y, a * y, b, step + 1);
    }
}
