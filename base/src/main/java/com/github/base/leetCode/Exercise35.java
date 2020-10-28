package com.github.base.leetCode;

/**
 * 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class Exercise35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 5, 9};
        System.out.println(new Exercise35().searchInsert(nums, 10));
    }
}
