package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 206号问题
 * Created At 2018/12/23
 */
public class Exercise206 {

    /**
     * 反转链表
     * @param head      链表的头节点
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.createList(arr, arr.length);
        ListUtil.printListNode(head);
        // 将链表进行反转
        ListNode pre = reverseList(head);
        ListUtil.printListNode(pre);
    }
}
