package com.example.algorithm.search;

/**
 * @Description : 剑指 Offer 55 - I. 二叉树的深度
 * @Author : young
 * @Date : 2022-07-06 9:51
 * @Version : 1.0
 **/
public class Test12 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
