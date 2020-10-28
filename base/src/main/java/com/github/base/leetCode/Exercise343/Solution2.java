package com.github.base.leetCode.Exercise343;

/**
 * Created By Seven.wk
 * Description: 动态规划方案
 * Created At 2019/01/18
 */
public class Solution2 {

    public int integerBreak(int n) {
        int[] memo = new int[n+1];
        memo[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i-1; j++) {
                memo[i] = Math.max(memo[i], Math.max(j * (i - j), j * memo[i - j]));
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).integerBreak(2));
        System.out.println((new Solution2()).integerBreak(10));
    }
}
