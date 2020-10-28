package com.github.base.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 二叉树的所有路径
 * Created At 2019/01/02
 */
public class Exercise257 {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // 处理叶子节点
        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }

        // 处理左子树
        List<String> leftPaths = binaryTreePaths(root.left);
        for (String leftPath : leftPaths) {
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(leftPath);
            res.add(sb.toString());
        }

        // 处理右子树
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String rightPath : rightPaths) {
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(rightPath);
            res.add(sb.toString());
        }

        return res;
    }
}
