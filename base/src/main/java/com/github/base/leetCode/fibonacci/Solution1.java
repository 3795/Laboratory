package com.github.base.leetCode.fibonacci;

/**
 * Created By Seven.wk
 * Description: 传统解法
 * Created At 2019/01/18
 */
public class Solution1 {

    private int num = 0;

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        num ++;

        return fib(n-1) + fib(n-2);
    }

    public int getNum() {
        return num;
    }

    public static void main(String[] args) {

        int n = 42;

        Solution1 solution = new Solution1();
        long startTime = System.currentTimeMillis();
        int res = solution.fib(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
        System.out.println("run function fib() " + solution.getNum() + " times.");
    }
}
