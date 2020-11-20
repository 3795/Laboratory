package com.github.base.offer;

import java.util.LinkedList;

/**
 * 用两个栈实现队列
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class Offer09 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.print(cQueue.deleteHead() + " ");
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.print(cQueue.deleteHead() + " ");
        System.out.print(cQueue.deleteHead() + " ");
        System.out.print(cQueue.deleteHead() + " ");
    }

}

class CQueue {

    private LinkedList<Integer> stack1;     // 使用LinkedList比使用Stack能获得更好的性能
    private LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {      // 这一步将stack1中所有的元素全部放入到stack2中，相当于加了一个缓存
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }
}
