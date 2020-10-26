package com.github.base.algorithm.search;

/**
 * Created By Seven.wk
 * Description: 二分查找算法
 * Created At 2018/11/10
 */
public class BinarySearch {

    /**
     * 二分查找法经典实现
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int middle;
        while (l <= r) {
            middle = l + (r - l) / 2;
//            middle = (l + r) / 2;   l + r可能产生溢出的问题
            if (arr[middle] < target) {
                l = middle + 1;
            } else if (arr[middle] > target) {
                r = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    /**
     * 二分查找法递归实现
     * @param arr
     * @param target
     * @return
     */
    public static int recursiveSearch(int[] arr, int target) {
        return recursive(arr, target, 0, arr.length - 1);
    }

    /**
     * 递归实现
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int recursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (arr[middle] == target) {
            return middle;
        } else if (arr[middle] > target) {
            return recursive(arr, target, left, middle - 1);
        } else {
            return recursive(arr, target, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(search(arr,9));

        System.out.println(recursiveSearch(arr, 9));

    }
}
