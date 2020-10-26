package com.github.base.algorithm.sort;

import static com.github.base.algorithm.sort.Util.*;

/**
 * Created By Seven.wk
 * Description: 插入排序
 * Created At 2018/11/08
 */
public class InsertSort {

    /**
     * 基础版排序算法
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    /**
     * 改进版排序算法
     * @param arr
     */
    public static void sortAdvance(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j=i; j>0 && arr[j-1] > tmp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        sortAdvance(arr);
        print(arr);
    }
}
