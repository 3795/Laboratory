package com.github.base.nowcoder;

import java.util.ArrayList;

/**
 * Created By Q.Hao
 * Description: 二叉树中和为某一值的路径
 * Created At 2019/3/5
 */
public class Offer24 {

    // 存放结果
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    // 存放遍历过的路径
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }

        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);

        // 进行路径回退，回退到上一级
        list.remove(list.size() - 1);

        return result;
    }
}
