package com.github.base.algorithm.sort;

import static com.github.base.algorithm.sort.Util.*;

/**
 * Created By Seven.wk
 * Description: 选择排序
 * Created At 2018/11/08
 */
public class SelectSort {

    public static void sort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
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
