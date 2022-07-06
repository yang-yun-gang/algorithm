package com.example.algorithm.search;

/**
 * @Description : 剑指 Offer 54. 二叉搜索树的第 k 大节点
 * @Author : young
 * @Date : 2022-07-06 9:33
 * @Version : 1.0
 **/
public class Test11 {

    private int res = 0;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (k <= 0 || root == null) {
            return;
        }

        // 右
        inorder(root.right);

        // 根
        if (--k == 0) {
            res = root.val;
            return;
        }

        // 左
        inorder(root.left);
    }

}
