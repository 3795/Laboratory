package com.github.base.algorithm.sort;

/**
 * Created By Seven.wk
 * Description: 工具类
 * Created At 2018/11/08
 */
public class Util {

    public static int[] arr = {10, 5, 1, 3, 8, 4, 9, 6, 2, 7};

    /**
     * 交换函数
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void print(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
