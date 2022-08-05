package com.example.algorithm.list;

/**
 * @Description : 剑指 Offer 24. 反转链表
 * @Author : young
 * @Date : 2022-08-05 10:10
 * @Version : 1.0
 **/
public class Test02 {
    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode p = head;
        ListNode res = reverseList(head.next);
        p.next.next = p;
        p.next = null;

        return res;
    }

    // 双指针
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

        Test02 test = new Test02();
        System.out.println(test.reverseList(a).val);
    }
}
