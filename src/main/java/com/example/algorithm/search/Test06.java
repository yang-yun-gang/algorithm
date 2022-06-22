package com.example.algorithm.search;

/**
 * @Description : 剑指 Offer 27. 二叉树的镜像
 * @Author : young
 * @Date : 2022-06-22 11:03
 * @Version : 1.0
 **/
public class Test06 {
    // 后序遍历
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        // 保存left指针
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}


