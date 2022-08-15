package com.example.algorithm.list;

/**
 * @Description : 19. 删除链表的倒数第 N 个结点
 * @Author : young
 * @Date : 2022-08-15 10:10
 * @Version : 1.0
 **/
public class Test04 {
    // 普通暴力
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 虚拟节点
        ListNode node = new ListNode();
        node.next = head;

        ListNode p = head;
        // 统计长度len
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        // 找到删除节点 标号以0开始
        p = head;
        ListNode pre = node;
        int deleteNodeNum = len - n;
        int cnt = 0;
        while (cnt < deleteNodeNum) {
            pre = p;
            p = p.next;
            cnt++;
        }

        // 删除节点
        pre.next = p.next;

        return node.next;
    }

    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟节点
        ListNode node = new ListNode();
        node.next = head;

        ListNode p = head;
        ListNode t = p;
        ListNode pre = node;
        while (n > 0) {
            t = t.next;
            n--;
        }

        while (t != null) {
            pre = p;
            p = p.next;
            t = t.next;
        }

        pre.next = p.next;

        return node.next;
    }
}
