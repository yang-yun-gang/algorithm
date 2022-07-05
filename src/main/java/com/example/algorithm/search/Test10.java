package com.example.algorithm.search;

/**
 * @Description : 剑指 Offer 36. 二叉搜索树与双向链表
 * @Author : young
 * @Date : 2022-06-24 12:10
 * @Version : 1.0
 **/
public class Test10 {

    Node pre, head;
    public Node treeToDoublyList(Node root) {

        if (root == null) return null;
        inorder(root);
        head.left = pre;
        pre.right = head;

        return head;
    }

    // 中序遍历框架
    private void inorder(Node root) {

        if (root == null) return;

        // 左
        inorder(root.left);

        // print root 在框架里面更改核心代码，引入pre记录上一个节点
        if (pre == null) {
            // 第一个节点
            head = root;
        } else {
            root.left = pre;
            pre.right = root;
        }
        pre = root;

        // 右
        inorder(root.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
