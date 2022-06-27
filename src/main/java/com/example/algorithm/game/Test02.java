package com.example.algorithm.game;

/**
 * @Description : 力扣6100. 统计放置房子的方式数 超时 正确解法见dp/Test02
 * @Author : young
 * @Date : 2022-06-26 10:40
 * @Version : 1.0
 **/
public class Test02 {

    private boolean[] houses;

    private int cnt;

    private int n;

    public int countHousePlacements(int n) {

        this.houses = new boolean[n];
        this.n = n;
        this.cnt = 1;

        for (int i = 0; i < n; i++) {
            dfs(i);
        }

        return (cnt * cnt) % (100000007);
    }

    // 放置房子
    private void dfs(int i) {
        if (houses[i]) return;

        // 如果存在房子相邻的情况
        int pre = i - 1;
        int after = i + 1;
        if (pre >= 0 && houses[pre]) return;
        if (after < n && houses[after]) return;

        // 在i上放置一个房子
        houses[i] = true;
        cnt++;
        // j从i+2开始，避免重复可能
        for (int j = i + 2; j < n; j++) {
            dfs(j);
        }
        houses[i] = false;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.countHousePlacements(1000));
    }
}
