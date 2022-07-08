package com.example.algorithm.search;

/**
 * @Description : 剑指 Offer 55 - II. 平衡二叉树
 * @Author : young
 * @Date : 2022-07-06 10:11
 * @Version : 1.0
 **/
public class Test13 {
    public boolean isBalanced(TreeNode root) {
        return postorder(root) != -1;
    }

    // 后序遍历 返回树的深度 若树深为-1表示不是平衡二叉树 可提前剪枝
    private int postorder(TreeNode root) {

        if (root == null) return 0;
        // 左
        int left = postorder(root.left);
        if (left == -1) return -1;
        // 右
        int right = postorder(root.right);
        if (right == -1) return -1;
        // 根
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
