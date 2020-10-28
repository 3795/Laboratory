package com.github.base.leetCode;

import java.util.Stack;

/**
 * 设计一个最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    private Stack<Integer> data;

    private Stack<Integer> helper;

    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.empty() || x <= helper.peek()) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if (!data.empty()) {
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if (!data.empty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，操作非法");
    }

    public int getMin() {
        if (!helper.empty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，操作非法");
    }

}
