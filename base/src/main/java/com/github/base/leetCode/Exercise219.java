package com.github.base.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Seven.wk
 * Description: 219号问题：是否存在存在重复元素
 * Created At 2018/12/11
 */
public class Exercise219 {

    public static boolean solutionA(int[] nums, int k) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean solutionB(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        if (k < 1) {
            return false;
        }

        Set<Integer> record = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }

            record.add(nums[i]);

            if (record.size() == k + 1) {
                record.remove(nums[i-k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(solutionA(nums, k));
    }
}
