package com.example.algorithm.search;

/**
 * @Description : 剑指 Offer 26. 树的子结构
 * @Author : young
 * @Date : 2022-06-21 15:08
 * @Version : 1.0
 **/
public class Test05 {
    // 先序遍历
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;

        // 判断当前A的根
        if (check(A, B)) return true;

        // 判断A的左右
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean check(TreeNode A, TreeNode B) {
        // B遍历完了
        if (B == null) return true;
        // B没遍历完 A就完了
        if (A == null) return false;
        if (A.val != B.val) return false;
        return check(A.left, B.left) && check(A.right, B.right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}