package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 203号问题
 * Created At 2018/12/23
 */
public class Exercise203 {

    /**
     * 方法一：常规方法
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElementsA(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        // 防止传入空的头指针或者指针被删空
        if (head == null) {
            return null;
        }


        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 方法二：设置虚拟头节点
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElementsB(ListNode head, int val) {
        // 设置虚拟头节点，该节点永远不会被访问
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // 让当前节点指向虚拟头节点
        ListNode cur = dummyNode;

        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        ListNode head = ListUtil.createList(arr, arr.length);
        ListNode resultHead = removeElementsA(head, 1);
        ListUtil.printListNode(resultHead);
    }
}
