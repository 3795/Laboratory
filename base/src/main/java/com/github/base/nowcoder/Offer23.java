package com.github.base.nowcoder;

/**
 * Created By Q.Hao
 * Description: 二叉搜索树的后序遍历序列
 * BST的后序遍历的合法序列定义：对于一个序列S，最后一个元素是X（根元素），
 * 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于X，
 * 后一段（右子树）大于X，且这两段子树也是合法的后序序列
 * Created At 2019/03/03
 */
public class Offer23 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return jduge(sequence, 0, sequence.length - 1);
    }

    private boolean jduge(int[] sequence, int l, int r) {
        if (l >= r) {
            return true;
        }

        int i = r;
        while (i > l && sequence[i-1] > sequence[r]) {
            --i;        // 找到临界点
        }
        for (int j=i-1; j>=l; --j) {
            if (sequence[j] > sequence[r]) {
                return false;
            }
        }
        return (jduge(sequence, 0, i-1) && jduge(sequence, i, r-1));
    }

}
