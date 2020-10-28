package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 237号问题
 * Created At 2018/12/24
 */
public class Exercise237 {

    public static void deleteNode(ListNode node) {
        if(node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}

