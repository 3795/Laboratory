package com.github.base.offer;

/**
 * 实现一个包含min函数的栈，调用min函数能够得到当前栈中最小的元素值，其他方面和栈一模一样
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 解决方案：使用链表来实现这个栈结构，反向建立链表，并在新建每个头节点时，保存当前链表中的最小值
 * 调用min函数时，直接把这个最小值返回就行
 */
public class Offer30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

}

class MinStack {

    private Node head;

    public MinStack() {
    }

    /**
     * 压入元素
     *
     * @param x
     */
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            // 这个地方是在反向建立链表，将新进来的每个元素作为新的head节点，每次也是对head节点进行操作，即可实现需求
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    /**
     * 出栈栈顶元素
     */
    public void pop() {
        head = head.next;
    }

    /**
     * 得到当前栈中的最小值
     *
     * @return
     */
    public int min() {
        return head.min;
    }

    /**
     * 得到当前栈顶元素的值
     *
     * @return
     */
    public int top() {
        return head.val;
    }

    private class Node {
        int val;        // 当前栈帧的值
        int min;        // 压入这个栈元素时，栈中的最小值
        Node next;      // 下一个栈元素

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}


