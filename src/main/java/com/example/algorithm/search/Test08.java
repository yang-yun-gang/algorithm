package com.example.algorithm.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description : 剑指 Offer 32. 从上到下打印二叉树
 * @Author : young
 * @Date : 2022-06-23 10:21
 * @Version : 1.0
 **/
public class Test08 {
    /**
     * @Description: 同层按从左到右打印
     * @Author: young
     * @Date: 2022-06-24 10:37
     * @Param root:
     * @return: int[]
     * @Version: 1.0
     **/
    public int[] levelOrder1(TreeNode root) {
        if (root == null) return new int[0];
        // 借助队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * @Description: 在上述基础上，每一层打印一行
     * @Author: young
     * @Date: 2022-06-24 10:37
     * @Param root:
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     * @Version: 1.0
     **/
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new LinkedList<>();

        // 借助队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        // 队列目前的数目就是该层的节点
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            // 将同一层的全部出队
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }

        return res;
    }

    /**
     * @Description: 在上述基础上，奇数层正序，偶数层倒叙打印
     * @Author: young
     * @Date: 2022-06-24 10:45
     * @Param root:
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     * @Version: 1.0
     **/
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) return new LinkedList<>();

        // 借助队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);

        // 记录层数
        int level = 1;
        // 队列目前的数目就是该层的节点
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            // 将同一层的全部出队
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (level % 2 != 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
            level++;
        }

        return res;
    }
}
