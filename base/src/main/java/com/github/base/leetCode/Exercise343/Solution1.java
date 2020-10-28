package com.github.base.leetCode.Exercise343;

import java.util.Arrays;

/**
 * Created By Seven.wk
 * Description: 整数拆分
 * 使用记忆搜索法
 * Created At 2019/01/18
 */
public class Solution1 {
    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return breakInteger(n);
    }

    // 将n进行分割，至少分割为两部分，求解最大的乘积
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int res = -1;
        for (int i=1; i<n; i++) {
            res = Math.max(res, Math.max(i*(n-i), i*breakInteger(n-i)));
        }
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).integerBreak(2));
        System.out.println((new Solution1()).integerBreak(10));
    }
}
