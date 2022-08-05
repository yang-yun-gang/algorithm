package com.example.algorithm.list;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description : 剑指 Offer 06. 从尾到头打印链表
 * @Author : young
 * @Date : 2022-08-04 10:20
 * @Version : 1.0
 **/
public class Test01 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int len = stack.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Test01 test = new Test01();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;
        int[] res = test.reversePrint(a);
        Arrays.stream(res).forEach(s-> System.out.print(s + " "));
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
