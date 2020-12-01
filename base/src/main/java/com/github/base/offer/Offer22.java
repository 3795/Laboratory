package com.github.base.offer;

import com.github.base.offer.common.ListNode;

/**
 * 链表中倒数第k个节点
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class Offer22 {

    /**
     * 使用双指针法求解，时间复杂度：O(n)；空间复杂度：O(1)
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (i < k) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            i++;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
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
        ListNode result = getKthFromEnd(head, 2);
        ListNode.printListNode(result);
    }
}
