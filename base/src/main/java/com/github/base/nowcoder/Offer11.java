package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 二进制中1的个数
 * Created At 2019/02/23
 */
public class Offer11 {

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n = n & (n-1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(10));
    }

}
