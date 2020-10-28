package com.github.base.nowcoder;

/**
 * Created By Q.Hao
 * Description: 复杂链表的复制
 * 遍历原链表，复制每一个节点
 * 将复制的节点插入原节点后
 * 将链表拆分成原链表和复制的链表
 * 配合图形分析效果更佳
 * Created At 2019/3/7
 */
public class Offer25 {

    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // 第一次遍历
        RandomListNode current = pHead;
        while (current != null) {
            RandomListNode node = new RandomListNode(current.label);
            node.next = current.next;
            current.next = node;
            current = node.next;
        }

        // 从头开始，再来一次
        current = pHead;
        while (current != null) {
            RandomListNode node = current.next;
            if (current.random != null) {
                node.random = current.random.next;
            }
            current = node.next;
        }

        // 进行拆分
        RandomListNode clonepHead = pHead.next;
        RandomListNode tmp;
        current = pHead;
        while (current.next != null) {
            tmp = current.next;
            current.next = tmp.next;
            current = tmp;
        }
        return clonepHead;
    }
}

class RandomListNode {

    int label;

    RandomListNode next = null;

    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
