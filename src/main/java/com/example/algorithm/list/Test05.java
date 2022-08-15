package com.example.algorithm.list;

import java.util.Stack;

/**
 * @Description : 234. 回文链表
 * @Author : young
 * @Date : 2022-08-15 11:22
 * @Version : 1.0
 **/
public class Test05 {
    public boolean isPalindrome2(ListNode head) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            n++;
        }
        if (n % 2 != 0) return false;
        Stack<Integer> stack = new Stack<>();
        p = head;
        for (int i = 1; i <= n / 2; i++) {
            stack.push(p.val);
            p = p.next;
        }

        // 后半段比较
        for (int i = n / 2 + 1; i <= n; i++) {
            if (p.val != stack.pop()) {
                return false;
            }
            p = p.next;
        }

        return true;

    }

    public boolean isPalindrome(ListNode head) {
        // 找到中点
        ListNode mid = findMid(head);
        // 反转后半部
        ListNode node = reverseList(mid.next);

        // 比较
        ListNode p = node;
        ListNode q = head;
        boolean res = true;
        while (p != null) {
            if (p.val != q.val) {
                res = false;
                break;
            }
            p = p.next;
            q = q.next;
        }

        // 复原后半部
        mid.next = reverseList(node);
        return res;
    }

    // 快慢指针寻找链表中间
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
