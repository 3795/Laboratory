package com.github.base.offer;

import java.util.HashSet;

/**
 * 剑指Offer03题：数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class Offer03 {

    /**
     * 解法1：使用双循环的方法，时间复杂度O(n^2)，空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * 解法2：使用原地置换的方法，但这种方法有明显的缺陷
     * 核心思想：如果数组中没有重复的数字，且无视数组的长度，那么数组排序后，数字0应该在下标0的位置，
     * 数字1在下标1的位置，数字100在下标100的位置，当排序过程中，交换数字时，发现目标下标位置的数字和待
     * 排序的数字相同时，就说明有重复数字
     * <p>
     * 缺陷：数组会越界，该算法成立的前提条件是数组足够大，有足够的空间让数字100放到下标100的位置
     * 如：[1, 7, 1]，该算法会运行失败，因为数字7不能放到下标7的位置
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    /**
     * 解法3：合理利用数据结构，时间复杂度O(n)，空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber3(nums));
    }
}
