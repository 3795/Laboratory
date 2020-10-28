package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 合并两个有序链表
 * Created At 2019/01/22
 */
public class Exercise21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }

        ListNode p = l1;
        ListNode q = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (p != null || q != null) {
            if (p == null) {
                cur.next = new ListNode(q.val);
                q = q.next;
            } else if (q == null) {
                cur.next = new ListNode(p.val);
                p = p.next;
            } else {
                if (p.val > q.val) {
                    cur.next = new ListNode(q.val);
                    q = q.next;
                } else {
                    cur.next = new ListNode(p.val);
                    p = p.next;
                }
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        int[] b = {1, 3, 4};
        ListNode l1 = ListUtil.createList(a, a.length);
        ListNode l2 = ListUtil.createList(b, b.length);
        ListNode head = mergeTwoLists(l1, l2);
        ListUtil.printListNode(head);
    }
}
