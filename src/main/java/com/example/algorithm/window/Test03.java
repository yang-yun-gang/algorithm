package com.example.algorithm.window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description : 剑指 Offer 59 - II. 队列的最大值
 * @Author : young
 * @Date : 2022-08-09 9:49
 * @Version : 1.0
 **/
public class Test03 {

}

// 最大队列
class MaxQueue {

    Deque<Integer> A;
    Deque<Integer> B;

    public MaxQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public int max_value() {
        return B.isEmpty() ? -1 : B.peek();
    }

    // 维持一个单调减队列
    public void push_back(int value) {
        while (!B.isEmpty() && B.peekLast() < value) {
            B.removeLast();
        }
        A.addLast(value);
        B.addLast(value);
    }

    public int pop_front() {
        if (A.isEmpty()) {
            return -1;
        }
        if (A.peek().equals(B.peek())) {
            B.removeFirst();
        }
        return A.removeFirst();
    }
}
