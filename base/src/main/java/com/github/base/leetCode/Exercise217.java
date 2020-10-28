package com.github.base.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Seven.wk
 * Description: 217号问题
 * Created At 2018/12/12
 */
public class Exercise217 {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> record = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            } else {
                record.add(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
