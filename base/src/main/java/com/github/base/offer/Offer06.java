package com.github.base.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Offer06 {

    /**
     * 解法一：取值反向存储，时间复杂度：O(n)，空间复杂度：O(n)
     * 解法二：先获取链表的长度，再用长度new一个数组，再将值反向放入数组中，时间复杂度：O(n)，空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public static int[] reversePrint1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode point = head;
        while (point != null) {
            list.add(point.val);
            point = point.next;
        }
        int length = list.size();
        int[] result = new int[length];
        for (int x : list) {
            length--;
            result[length] = x;
        }
        return result;
    }

    /**
     * 解法3：使用栈来存储和取出
     *
     * @param head
     * @return
     */
    public static int[] reversePrint3(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode point = head;
        while (point != null) {
            stack.push(point.val);
            point = point.next;
        }

        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        int[] result = reversePrint3(head);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
