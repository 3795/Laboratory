package com.github.base.offer;

/**
 * 斐波那契数列
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Offer10 {

    /**
     * 解法一：递归法。缺点：大量的重复递归计算，容易超出时间限制
     * 这个解法的时间复杂度很高
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int result = fib1(n - 1) + fib1(n - 2);
        return result % 1000000007;
    }

    /**
     * 优化后的算法，时间复杂度：O(n)，空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (a + b) % 1000000007;
            a = b;
            b = result;
        }
        return result;
    }

    /**
     * 使用动态规划解题，时间复杂度：O(n)，空间复杂度：O(n)
     * 比解法2要稍逊一筹
     *
     * @param n
     * @return
     */
    public static int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib3(5));
    }
}
