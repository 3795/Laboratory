package com.github.base.algorithm.sort;

import static com.github.base.algorithm.sort.Util.*;

/**
 * Created By Seven.wk
 * Description: 插入排序
 * Created At 2018/11/08
 */
public class InsertSort {

    /**
     * 基础版排序算法；时间复杂度最差为O(n^2)，空间复杂度：O(1)
     * 原理：将序列的第一个元素看成是一个有序序列，然后从第二个元素开始逐个向该有序的子序列插入元素，直至整个序列有序
     * 这个算法基础的部分在于，使用了基础的swap算法，中间会多次的进行赋值交换
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * 改进版排序算法
     * 改进的地方在于，不用多次的进行swap算法，减少了大量的赋值操作，直接用arr[j] = arr[j - 1]的操作，使目标元素归位
     *
     * @param arr
     */
    public static void sortAdvance(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        sortAdvance(arr);
        print(arr);
    }
}
