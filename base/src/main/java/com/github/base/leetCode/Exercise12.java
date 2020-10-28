package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 整数转罗马数字
 * Created At 2019/01/31
 */
public class Exercise12 {

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder res = new StringBuilder();
        for (int i=0; i<values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(reps[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1));
    }
}
