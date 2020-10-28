package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 二维数组中的查找
 * Created At 2019/02/21
 */
public class Offer01 {

    /**
     * 双循环暴力解法
     * @param target
     * @param array
     * @return
     */
    public static boolean findA(int target, int [][] array) {
        int height = array.length;
        int weight = array[0].length;
        for (int i=0; i<height; i++) {
            for (int j=0; j<weight; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 巧解
     * @return
     */
    public static boolean findB(int target, int [][] array) {
        int height = array.length;
        int weight = array[0].length;
        if (weight == 0) {
            return false;
        }
        for (int i=height-1; i>=0; i--) {
            if (target >= array[i][0]) {
                for (int j=0; j<weight; j++) {
                    if (target == array[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] arr = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        int[][] arr = {{}};
        System.out.println(findA(5, arr));
        System.out.println(findB(7, arr));

    }
}
