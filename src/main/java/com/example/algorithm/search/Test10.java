package com.example.algorithm.search;

/**
 * @Description : 剑指 Offer 36. 二叉搜索树与双向链表
 * @Author : young
 * @Date : 2022-06-24 12:10
 * @Version : 1.0
 **/
public class Test10 {
    public Node treeToDoublyList(Node root) {
        return null;
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
