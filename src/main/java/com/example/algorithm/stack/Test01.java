package com.example.algorithm.stack;

import java.util.Stack;

/**
 * @Description : 剑指 Offer 09. 用两个栈实现队列
 * @Author : young
 * @Date : 2022-08-04 10:35
 * @Version : 1.0
 **/
public class Test01 {

}
class CQueue {

    private Stack<Integer> A;
    private Stack<Integer> B;

    public CQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void appendTail(int value) {
        B.push(value);
    }

    public int deleteHead() {
        if (A.empty()) {
            if (B.empty()) {
                return -1;
            }

            while (!B.empty()) {
                A.push(B.pop());
            }
        }

        return A.pop();
    }
}
