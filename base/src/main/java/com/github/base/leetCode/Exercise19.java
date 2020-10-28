package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 删除链表倒数第N个节点
 * Created At 2018/12/26
 */
public class Exercise19 {

    /**
     * 方法一：通过双重遍历，找到节点位置再删除
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndA(ListNode head, int n) {

        // 设置虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length ++;
        }

        int k = length - n;
        ListNode cur = dummyHead;
        for (int i=0; i<k; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return dummyHead.next;
    }

    /**
     * 方法二：通过双指针，构造一个长度固定的滑动窗口，只需要遍历一次链表
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndB(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode left = dummyHead;      // 左边界指针
        ListNode right = dummyHead;     // 右边界指针

        for (int i=0; i<n+1; i++) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.createList(a, a.length);
        ListNode result = removeNthFromEndB(head, 2);
        ListUtil.printListNode(result);
    }
}

