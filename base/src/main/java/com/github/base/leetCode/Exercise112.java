package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 路径总和
 * Created At 2019/01/02
 */
public class Exercise112 {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
