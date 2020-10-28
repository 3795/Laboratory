package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 两数相加
 * Created At 2019/01/20
 */
public class Exercise2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummyHead;
        int carry = 0;
        while(p != null || q != null) {
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            int sum = carry + x + y;
            System.out.println("sum = " + sum);
            carry = sum / 10;
            System.out.println("carry = " + carry);
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3};
        int[] b = {5, 6, 4};
        ListNode l1 = ListUtil.createList(a, a.length);
        ListNode l2 = ListUtil.createList(b, b.length);
        ListNode result = addTwoNumbers(l1, l2);
        ListUtil.printListNode(result);

        long c = 10;
        long d = c % 10;
    }
}
