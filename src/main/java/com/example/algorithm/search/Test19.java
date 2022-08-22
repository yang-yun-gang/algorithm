package com.example.algorithm.search;

/**
 * @Description : 437. 路径总和 III
 * @Author : young
 * @Date : 2022-08-22 12:09
 * @Version : 1.0
 **/
public class Test19 {

    private int res = 0;
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) return 0;
        // 包含根
        dfs(root, targetSum);

        // 不包含根
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return res;
    }

    // 已结点root起 往下检查
    private void dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum == root.val) {
            res++;
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
    }
}
