package com.example.algorithm.list;

/**
 * @Description : 328 奇偶链表
 * @Author : young
 * @Date : 2022-08-16 9:45
 * @Version : 1.0
 **/
public class Test06 {
    // 普通暴力
    public ListNode oddEvenList(ListNode head) {
        // 遍历 找到最后一个奇数
        ListNode p = head;
        ListNode lastOdd = head;
        int cnt = 1;
        while (p != null) {
            if (cnt % 2 != 0) {
                lastOdd = p;
            }
            p = p.next;
            cnt++;
        }

        // 再度遍历 将偶数全部移到末尾
        cnt = 1;
        p = head;
        ListNode tail = lastOdd;
        ListNode pre = new ListNode();
        while (p != lastOdd) {
            if (cnt % 2 == 0) {
                // 移到末尾
                ListNode tmp = tail.next;
                ListNode nextNode = p.next;
                pre.next = nextNode;
                tail.next = p;
                p.next = tmp;
                tail = tail.next;
                p = nextNode;
            } else {
                pre = p;
                p = p.next;
            }
            cnt++;
        }

        return head;
    }

    // 奇偶分离
    public ListNode oddEvenList1(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
