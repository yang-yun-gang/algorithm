package com.example.algorithm.search;

/**
 * @Description : 剑指 Offer 28. 对称的二叉树
 * @Author : young
 * @Date : 2022-06-22 11:33
 * @Version : 1.0
 **/
public class Test07 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
