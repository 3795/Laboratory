package com.github.base.offer.common;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public static void printListNode(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + "->");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }
}
