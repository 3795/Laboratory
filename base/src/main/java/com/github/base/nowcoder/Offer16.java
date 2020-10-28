package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 合并两个有序链表
 * Created At 2019/02/25
 */
public class Offer16 {

    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        ListNode q = list1;
        ListNode p = list2;
        while (q != null || p != null) {
            if (q == null) {
                current.next = p;
                p = p.next;
            } else if (p == null) {
                current.next = q;
                q = q.next;
            } else {
                if (q.val <= p.val) {
                    current.next = q;
                    q = q.next;
                } else {
                    current.next = p;
                    p = p.next;
                }
            }
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 5, 7, 8};
        int[] b = {9};
        ListNode list1 = Offer03.create(a);
        ListNode list2 = Offer03.create(b);

        ListNode head = Merge(list1, list2);
        Offer03.print(head);
    }
}
