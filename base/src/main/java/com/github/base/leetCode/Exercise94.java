package com.github.base.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 中序遍历树
 * Created At 2018/12/27
 */
public class Exercise94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    /**
     * 执行中序遍历
     * @param node
     * @param list
     */
    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.val);
            inorderTraversal(node.right, list);
        }
    }

    public static void main(String[] args) {

    }
}
