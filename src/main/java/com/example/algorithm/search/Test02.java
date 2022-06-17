package com.example.algorithm.search;

import java.util.Arrays;

/**
 * @Description : 力扣473 火柴拼正方形 https://leetcode.cn/problems/matchsticks-to-square/
 * @Author : young
 * @Date : 2022-06-17 10:22
 * @Version : 1.0
 **/
public class Test02 {

    int[] matchsticks;
    int n;
    boolean res = false;
    int cnt = 0;

    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        this.n = matchsticks.length;

        // 如果总数不是4的倍数 直接返回
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return res;

        // 从大到小取火柴
        Arrays.sort(matchsticks);

        put(new int[4], n - 1);

        return res;
    }

    // 放置一根火柴
    private void put(int[] matrix, int station) {

        // 火柴放完了
        if (station < 0) {
            // 判断是否构成正方形
            int edge = matrix[0];
            int j = 1;
            for (; j < matrix.length; j++) {
                if (edge != matrix[j]) {
                    break;
                }
            }
            if (j == matrix.length) {
                res = true;
            }
            return;
        }

        // 如果已经找到了
        if (res) {
            return;
        }

        // 剪枝：如果剩余火柴数<当前未放置的区域数，必然存在一个区域没有放置火柴，肯定不能构成正方形
        int k = 0;
        for (int item : matrix) {
            if (item == 0) k++;
        }
        if (station + 1 < k) return;

        cnt++;

        for (int i = 0; i < matrix.length; i++) {
            // 剪枝：第一根火柴只需要放在任意位置就好
            if (station == n - 1 && i > 0) return;
            // 将火柴放置在i
            matrix[i] += matchsticks[station];
            // 放置别的火柴
            put(matrix, station - 1);
            // 回溯
            matrix[i] -= matchsticks[station];
        }
    }

    public static void main(String[] args) {
        int[] matchsticks = new int[] {12,18,2,2,16,8,7,3,10,12,3,20,2,10,19};
        Test02 test02 = new Test02();
        System.out.println(test02.makesquare(matchsticks));
        System.out.println(test02.cnt);
    }
}
