package com.github.base.leetCode;

/**
 * 求众数
 * https://leetcode-cn.com/problems/majority-element/
 */
public class Exercise169 {

    public int majorityElement(int[] nums) {
        int count = 1;
        int major = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == major) {
                count ++;
            } else {
                count --;
                if (count == 0) {
                    major = nums[i+1];
                }
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Exercise169().majorityElement(arr));
    }
}
