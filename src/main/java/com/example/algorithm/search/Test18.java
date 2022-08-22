package com.example.algorithm.search;

/**
 * @Description : 543. 二叉树的直径
 * @Author : young
 * @Date : 2022-08-22 10:55
 * @Version : 1.0
 **/
public class Test18 {
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }


    // 计算树高的同时 计算每个点为根时左右子树的直径 保留最大直径
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        res = (left + right > res) ? left + right : res;
        return Math.max(left, right) + 1;
    }
}
