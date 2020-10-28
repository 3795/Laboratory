package com.github.base.leetCode;

/**
 * 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Exercise160 {

    public static ListNode160 getIntersectionNode(ListNode160 headA, ListNode160 headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode160 curA = headA;
        ListNode160 curB = headB;
        while (lengthA != lengthB) {
            if (lengthA > lengthB) {
                curA = curA.next;
                lengthA--;
            } else {
                curB = curB.next;
                lengthB--;
            }
        }
        for (int i = 0; i < lengthA; i++) {
            if (curA.val == curB.val) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    static int getLength(ListNode160 head) {
        int length = 0;
        ListNode160 tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] listA = {0, 9, 1, 2, 4};
        int[] listB = {3, 2, 4, 8, 4, 5};
        ListNode160 listNode = new ListNode160();
        ListNode160 headA = listNode.genNode(listA);
        ListNode160 headB = listNode.genNode(listB);
        ListNode160 result = getIntersectionNode(headA, headB);
        if (result == null) {
            System.out.println("节点的值为 null");
        } else {
            System.out.println("节点的值为 " + result.val);
        }
    }
}

class ListNode160 {
    int val;

    ListNode160 next;

    ListNode160(int x) {
        val = x;
        next = null;
    }

    ListNode160() {

    }

    ListNode160 genNode(int[] arr) {
        ListNode160 head = new ListNode160(arr[0]);
        ListNode160 tmp = head;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode160(arr[i]);
            tmp = tmp.next;
        }
        return head;
    }

    void printList(ListNode160 head) {
        ListNode160 tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }


}