package com.example.algorithm.search;

/**
 * @Description : 搜索与回溯模板 参考练习Test01, Test02
 * @Author : young
 * @Date : 2022-06-19 12:57
 * @Version : 1.0
 **/
public class template01 {
    int res;
    int n;
    int[] nums;

    public int method(int[] nums) {
        this.n = nums.length;
        this.nums = nums;

        // 递归穷举每一次的动作
        action(new int[4], n - 1);

        return res;
    }

    // 单次动作 如分饼干给学生、放置火柴
    private void action(int[] possible, int p) {

        // bfs停止
        if (p < 0) {
            // ...
            return;
        }

        // 在这里进行剪枝操作


        // 本次动作存在的可能
        for(int i = 0; i < possible.length; i++) {
            // 剪枝：第一次动作随意选择一种可能
            if (p == n - 1 && i > 0) return;

            // 当前可能增加
            possible[i] += nums[p];
            // 在当前情况下，探究下一次可能
            action(possible, p - 1);
            // 回溯
            possible[i] -= nums[p];
        }
    }
}
