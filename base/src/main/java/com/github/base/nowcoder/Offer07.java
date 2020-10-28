package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 斐波那契数列
 * Created At 2019/02/21
 */
public class Offer07 {

    /**
     * 斐波那契数列的递归实现
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i=2; i<=n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Offer07().fibonacci(3));
    }
}
