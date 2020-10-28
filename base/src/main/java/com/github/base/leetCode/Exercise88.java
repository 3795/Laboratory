package com.github.base.leetCode;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Exercise88 {

    public void merge(int[] nums1, int m, int[]nums2, int n) {
        int[] tem = new int[m];
        System.arraycopy(nums1, 0, tem, 0, m);

        int p = 0, q = 0, i = 0;
        while (p < m && q < n) {
            if (tem[p] <= nums2[q]) {
                nums1[i++] = tem[p++];
            } else {
                nums1[i++] = nums2[q++];
            }
        }

        if (p < m) {
            System.arraycopy(tem, p, nums1, p + q, m + n - p - q);
        }

        if (q < n) {
            System.arraycopy(nums2, q, nums1, p + q, m + n - p - q);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Exercise88().merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
