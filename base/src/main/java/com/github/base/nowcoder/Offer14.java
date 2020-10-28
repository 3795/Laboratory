package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 链表中倒数第K个节点
 * Created At 2019/02/24
 */
public class Offer14 {

    /**
     * 定义两个指针
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 0) {
            return null;
        }

        ListNode pre = head;
        ListNode last = head;

        for (int i=1; i<k; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                // 说明链表长度不够
                return null;
            }
        }

        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }

        return last;
    }
}
