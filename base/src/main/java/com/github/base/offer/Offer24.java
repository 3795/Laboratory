package com.github.base.offer;

import com.github.base.offer.common.ListNode;

/**
 * 反转链表
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class Offer24 {

    /**
     * 使用双指针法，进行局部反转
     * 时间复杂度：O(n)；空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = reverseList(head);
        ListNode.printListNode(result);
    }
}
