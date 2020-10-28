package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 反转链表，返回新链表的头
 * Created At 2019/02/24
 */
public class Offer15 {

    /**
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode reversedHead = null;
        ListNode pre = null;
        ListNode current = head;
        ListNode tmp = null;

        while (current != null) {
            tmp = current.next;
            if (tmp == null) {
                reversedHead = current;
            }
            current.next = pre;
            pre = current;
            current = tmp;
        }

        return reversedHead;
    }
}
