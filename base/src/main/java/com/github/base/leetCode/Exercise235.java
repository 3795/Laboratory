package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 在二叉树搜索树中寻找最近公共祖先
 * Created At 2019/01/03
 */
public class Exercise235 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
