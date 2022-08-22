package com.example.algorithm.list;

/**
 * @Description : 148. 排序链表
 * @Author : young
 * @Date : 2022-08-16 10:53
 * @Version : 1.0
 **/
public class Test07 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 左边链表头head，右边链表头rightHead，二者之间断开
        ListNode rightHead = slow.next;
        slow.next = null;

        // 左右排序递归
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并
        ListNode newHead = new ListNode();
        ListNode p = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left != null ? left : right;

        return newHead.next;
    }

    public static void main(String[] args) {
        Test07 test = new Test07();
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;

        test.sortList(a);
    }

}
