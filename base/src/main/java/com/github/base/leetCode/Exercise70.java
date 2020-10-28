package com.github.base.leetCode;

/**
 * 爬楼梯问题，使用斐波那契的方法求解，空间复杂度O(1)，时间复杂度为O(n)
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Exercise70 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;
        int third;
        for (int i=3; i<=n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new Exercise70().climbStairs(3));
    }

}
