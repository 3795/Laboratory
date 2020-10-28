package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 树的子结构
 * 输入两颗二叉树A，B，判断B不是A的子结构
 * Created At 2019/02/25
 */
public class Offer17 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = isSubtree(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }

    /**
     * 判断是不是子结构
     * 其中两个if的位置一定不能变
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        // 如果B树到达叶节点，为true
        if (root2 == null) {
            return true;
        }

        // 如果A树到达叶节点，为false
        if (root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            return (isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right));
        }

        return false;
    }
}
