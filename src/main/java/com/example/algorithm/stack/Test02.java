package com.example.algorithm.stack;

import java.util.Stack;

/**
 * @Description : 剑指 Offer 30. 包含 min 函数的栈
 * @Author : young
 * @Date : 2022-08-05 11:18
 * @Version : 1.0
 **/
public class Test02 {

}

class MinStack {

    Stack<Integer> A;
    Stack<Integer> B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.empty() || x <= B.peek()) {
            B.push(x);
        }
    }

    public void pop() {
        if (A.size() == 0) return;
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
