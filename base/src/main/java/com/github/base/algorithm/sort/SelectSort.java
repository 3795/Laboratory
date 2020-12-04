package com.github.base.algorithm.sort;

import static com.github.base.algorithm.sort.Util.*;

/**
 * Created By Seven.wk
 * Description: 选择排序
 * Created At 2018/11/08
 */
public class SelectSort {

    /**
     * 选择排序，就是将当前元素与后面的元素进行对比并交换，感觉比冒泡还笨一些
     * 每一轮循环下来，第i个元素的大小是确定的
     * 时间复杂度：O(n^2)，空间复杂度：O(1)
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        sort(arr);
        print(arr);
    }
}
