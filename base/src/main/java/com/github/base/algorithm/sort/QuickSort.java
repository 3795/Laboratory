package com.github.base.algorithm.sort;


import static com.github.base.algorithm.sort.Util.swap;

/**
 * Created By Seven.wk
 * Description: 快速排序
 * Created At 2018/11/12
 */
public class QuickSort {

    /**
     * 进行partition操作
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] arr, int l, int r) {
        int e = arr[l];
        int j = l;

        for (int i=l+1; i<r; i++) {
            if (arr[i] < e) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p);        // 对左边部分进行递归排序
        sort(arr, p+1, r);      // 对右边部分进行递归排序
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 0, 9};
        sort(arr);
        for(int i : arr)
            System.out.println(i);
    }
}
