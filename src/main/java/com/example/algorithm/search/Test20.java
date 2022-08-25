package com.example.algorithm.search;

/**
 * @Description : 108. 将有序数组转换为二叉搜索树
 * @Author : young
 * @Date : 2022-08-24 14:41
 * @Version : 1.0
 **/
public class Test20 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, i, mid - 1);
        node.right = dfs(nums, mid + 1, j);
        return node;
    }
}
