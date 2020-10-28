package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 重建二叉树
 * Created At 2019/02/21
 */
public class Offer04 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode head = new TreeNode(pre[0]);
        return head;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }
}