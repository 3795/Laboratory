package com.github.base.offer;

/**
 * 统计二进制数中1的个数
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Offer15 {

    /**
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 00000000000000000000000000001011;
        System.out.println(hammingWeight(a));
    }
}
