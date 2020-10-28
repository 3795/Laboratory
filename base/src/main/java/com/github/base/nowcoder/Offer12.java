package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 数值的整数次方
 * Created At 2019/02/24
 */
public class Offer12 {

    /**
     * 使用传统的暴力解法
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        double result = 1;

        for (int i=0; i<Math.abs(exponent); i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1/result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(4, 2));
    }

}
