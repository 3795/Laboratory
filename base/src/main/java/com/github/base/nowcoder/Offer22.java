package com.github.base.nowcoder;

import java.util.ArrayList;

/**
 * Created By Q.Hao
 * Description: 二叉树的层序遍历
 * Created At 2019/03/03
 */
public class Offer22 {

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> treeList = new ArrayList<>();
        if (root == null) {
            return list;
        }

        treeList.add(root);
        while (treeList.size() != 0) {
            TreeNode tmp = treeList.remove(0);
            list.add(tmp.val);
            if (tmp.left != null) {
                treeList.add(tmp.left);
            }
            if (tmp.right != null) {
                treeList.add(tmp.right);
            }
        }

        return list;
    }
}
