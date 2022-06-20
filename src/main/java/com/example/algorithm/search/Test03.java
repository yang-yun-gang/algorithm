package com.example.algorithm.search;

/**
 * @Description : 力扣79 单词搜索 https://leetcode.cn/problems/word-search/
 * @Author : young
 * @Date : 2022-06-20 9:37
 * @Version : 1.0
 **/
public class Test03 {

    private char[][] board;
    // 行
    private int m;
    // 列
    private int n;
    private String target;
    private boolean res;

    // 路径
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.target = word;
        this.visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 存在m*n个起始点
                dfs(0, i, j);
            }
        }

        return res;
    }

    private void dfs(int p, int i, int j) {

        // 已经找到了
        if (res) {
            return;
        }

        // 判断是否匹配完成
        if (p == target.length()) {
            res = true;
            return;
        }

        // 判断越界
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) return;

        // 判断是否是回路
        if (visited[i][j]) {
            return;
        }

        // 字符不匹配
        if (board[i][j] != target.charAt(p)) {
            return;
        }

        visited[i][j] = true;

        // 继续往上
        dfs(p + 1, i - 1, j);

        // 往下
        dfs(p + 1, i + 1, j);

        // 往左
        dfs(p + 1, i, j - 1);

        // 往右
        dfs(p + 1, i, j + 1);

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCB";
        Test03 test = new Test03();
        System.out.println(test.exist(board, word));
    }
}
