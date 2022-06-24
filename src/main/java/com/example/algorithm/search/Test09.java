package com.example.algorithm.search;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description : 剑指 Offer 34. 二叉树中和为某一值的路径
 * @Author : young
 * @Date : 2022-06-24 11:00
 * @Version : 1.0
 **/
public class Test09 {

    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // 先序遍历 由根走到叶子节点
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        // 没有找到
        if (root == null) return;

        path.addLast(root.val);
        // 找到符合条件的叶子节点了
        if (root.left == null && root.right == null && target == root.val) {
            res.add(new LinkedList<>(path));
        }

        dfs(root.left, target - root.val);
        dfs(root.right, target - root.val);
        path.removeLast();
    }
}
