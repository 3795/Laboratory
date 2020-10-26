package com.github.base.algorithm.sort;


import static com.github.base.algorithm.sort.Util.*;

/**
 * Created By Seven.wk
 * Description: 冒泡排序
 * Created At 2018/11/08
 */
public class BubbleSort {

    /**
     * 冒泡算法实现
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        sort(arr);
        print(arr);
    }
}
