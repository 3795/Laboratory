package com.github.base.offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Offer21 {

    /**
     * 使用双指针法求解，时间复杂度：O(n)，空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int index1 = 0;
        int index2 = 1;

        while (index2 < nums.length && index1 < nums.length) {
            if (nums[index2] % 2 == 1 && nums[index1] % 2 == 0 && index1 <= index2) {
                swap(nums, index1, index2);
                index1++;
                index2++;
            } else if (nums[index1] % 2 == 1) {
                index1++;
            } else {
                index2++;
            }
        }

        return nums;
    }

    public static void swap(int[] nums, int j, int k) {
        int tmp = nums[j];
        nums[j] = nums[k];
        nums[k] = tmp;
    }

    /**
     * 另一种更优雅的写法，只管快指针，不管慢指针
     *
     * @param nums
     * @return
     */
    public static int[] exchange2(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {
                swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 11, 14, 16, 15};
        int[] result = exchange(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
