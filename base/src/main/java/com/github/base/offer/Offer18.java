package com.github.base.offer;

import com.github.base.offer.common.ListNode;

/**
 * 删除链表中的节点
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Offer18 {

    /**
     * 时间复杂度：O(n)；空间复杂度：O(1)
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        // 如果头节点需要被删除
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode currentNode = head;
        ListNode nextNode = head.next;
        while (currentNode != null && nextNode != null) {
            if (nextNode.val == val) {
                currentNode.next = nextNode.next;
                return head;
            } else {
                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode.printListNode(deleteNode(head, 10));
    }
}
