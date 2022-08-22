package com.example.algorithm.search;

/**
 * @Description : 226. 翻转二叉树
 * @Author : young
 * @Date : 2022-08-19 11:35
 * @Version : 1.0
 **/
public class Test17 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }
}
