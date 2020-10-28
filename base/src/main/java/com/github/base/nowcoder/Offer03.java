package com.github.base.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 从尾到头打印链表
 * Created At 2019/02/21
 */
public class Offer03 {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> tmpList = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp != null) {
            tmpList.add(tmp.val);
            tmp = tmp.next;
        }
        for(int i=tmpList.size()-1; i>=0; i--) {
            result.add(tmpList.get(i));
        }
        return result;
    }

    public static ListNode create(int[] arr) {
        ListNode node = new ListNode(arr[0]);
        ListNode tmp = node;
        for (int i=1; i<arr.length; i++) {
            tmp.next = new ListNode(0);
            tmp.next.val = arr[i];
            tmp = tmp.next;
        }
        return node;
    }

    public static void print(ListNode head) {
        ListNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = create(arr);
//        print(head);
        List<Integer> list = printListFromTailToHead(head);
        list.forEach(System.out::println);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
    this.val = val;
    }
}