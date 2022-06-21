package com.example.algorithm.search;

/**
 * @Description : 剑指offer13 机器人的运动范围
 * @Author : young
 * @Date : 2022-06-21 13:55
 * @Version : 1.0
 **/
public class Test04 {

    private int m;
    private int n;
    private int k;
    private boolean[][] visited;
    private int res = 0;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];

        dfs(0, 0);
        return res;
    }

    // dfs
    private void dfs(int i, int j) {
        // 如果该点超了
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || !isPermission(i, j) || visited[i][j]) return;
        visited[i][j] = true;
        res++;
        // 上
        dfs(i - 0, j);

        // 下
        dfs(i + 1, j);

        // 左
        dfs(i, j - 1);

        // 右
        dfs(i, j + 1);

    }

    private boolean isPermission(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }

    public static void main(String[] args) {
        Test04 t = new Test04();
        System.out.println(t.movingCount(3, 1, 0));
    }
}
