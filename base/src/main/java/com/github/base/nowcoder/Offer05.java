package com.github.base.nowcoder;

import java.util.Stack;

/**
 * Created By Seven.wk
 * Description: 用两个栈实现一个队列
 * Created At 2019/02/21
 */
public class Offer05 {

    private static Stack<Integer> stack1 = new Stack<Integer>();
    private static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();

        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            push(i);
        }

        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
