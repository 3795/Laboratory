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
     * 时间复杂度：O(n^2)，空间复杂度：O(1)
     * 原理：
     * 1. 双循环排序，每经过一次内排序后，数组最后一位的元素是最大值
     * 2. 因为每一次内循环后，可以确定最后一位元素的有序性，那么下一次内循环时遍历的元素就可以减1
     * 3. 内循环每次可以确定一个元素的有序性，外循环的目的就是让每个元素达到有序性
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        sort(arr);
        print(arr);
    }
}
