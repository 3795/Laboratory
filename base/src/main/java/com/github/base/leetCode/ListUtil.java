package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 操作链表的工具
 * Created At 2018/12/23
 */
public class ListUtil {

    /**
     * 创建一个链表
     * @param arr   链表中存放的值
     * @param n     链表节点个数
     * @return      链表的头节点
     */
    public static ListNode createList(int[] arr, int n) {
        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for (int i=1; i<n; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printListNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("Null");
    }
}

/**
 * 链表结构
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}
