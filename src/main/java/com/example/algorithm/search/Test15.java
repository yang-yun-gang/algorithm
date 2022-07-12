package com.example.algorithm.search;

/**
 * @Description : 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @Author : young
 * @Date : 2022-07-12 17:06
 * @Version : 1.0
 **/
public class Test15 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 根
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 左右
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p q分于两侧
        if (left != null && right != null) {
            return root;
        }

        return (left == null) ? right : left;
    }

}
