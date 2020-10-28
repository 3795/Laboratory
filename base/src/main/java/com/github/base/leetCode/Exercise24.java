package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 两两交换链表中的节点
 * Created At 2018/12/24
 */
public class Exercise24 {

    public static ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // p节点初始赋值为虚拟头节点
        ListNode p = dummyHead;

        while(p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            // 重新建立连接
            node1.next = next;
            node2.next = node1;
            // 与之前的链表进行连接
            p.next = node2;

            p = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.createList(arr, arr.length);
        ListNode result = swapPairs(head);
        ListUtil.printListNode(result);
    }
}
