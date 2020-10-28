package com.github.base.nowcoder;

import java.util.Stack;

/**
 * Created By Seven.wk
 * Description: 包含min函数的栈
 * Created At 2019/03/01
 */
public class Offer20 {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    private int min = Integer.MIN_VALUE;

    public void push(int node) {
        stack.push(node);
        if (minStack.empty()) {
            minStack.push(node);
            min = node;
        } else {
            if (node < min) {
                minStack.push(node);
                min = node;
            }
        }
    }

    public void pop() {
        int result = stack.pop();
        if (result == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
