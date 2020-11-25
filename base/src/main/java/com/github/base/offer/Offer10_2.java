package com.github.base.offer;

/**
 * 青蛙跳台阶的问题
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class Offer10_2 {

    /**
     * 使用动态规划的方法进行求解，时间复杂度：O(n)，空间复杂度：O(n)
     * 但是可以使用10-1中的优化解法，对空间复杂度进行优化，达到O(1)的水平
     *
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(0));
        System.out.println(numWays(1));
        System.out.println(numWays(2));
        System.out.println(numWays(7));
    }
}
