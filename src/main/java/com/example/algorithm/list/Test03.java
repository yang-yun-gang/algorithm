package com.example.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 剑指 Offer 35. 复杂链表的复制
 * @Author : young
 * @Date : 2022-08-08 9:13
 * @Version : 1.0
 **/
public class Test03 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 构造hashmap 原节点与新节点对应
        Map<Node, Node> map = new HashMap<>();

        // 第一遍遍历 对应节点
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }

        // 第二遍遍历 确定指向
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
