package com.example.algorithm.game;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description : 蔚来 n个城市，每个城市包含距离x(0号位)，快乐值y(1号位)。
 * 小明想去任意个城市，找出一些城市，满足其中任意两个城市之间距离小于k，快乐值的和最大，输出快乐值和。
 * @Author : young
 * @Date : 2022-07-16 8:43
 * @Version : 1.0
 **/
public class Test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] citys = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                citys[i][j] = sc.nextInt();
            }
        }

        //按距离排序
        Arrays.sort(citys, (o1, o2) -> o1[0] - o2[0]);

        // 滑动窗口
        int l = 0, r = 0;
        int sum = 0, res = 0;
        while (l < n && r < n) {
            // 距离越界 缩小l
            if (citys[r][0] - citys[l][0] >= k) {
                sum -= citys[l][1];
                l++;
                continue;
            }

            // 扩大r
            sum += citys[r][1];
            r++;
            res = Math.max(sum, res);
        }

        System.out.println(res);
    }
}
