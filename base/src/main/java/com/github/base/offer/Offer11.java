package com.github.base.offer;

/**
 * 旋转数组中的最小数字
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class Offer11 {

    /**
     * 解法一：就用最简单的暴力解法，直接遍历一遍。
     * 时间复杂度：O(n)，空间复杂度：O(1)
     *
     * @param numbers
     * @return
     */
    public static int minArray1(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }

    /**
     * 解法二：使用二分查找法
     * 时间复杂度：O(log n)，空间复杂度：O(1)
     *
     * @param numbers
     * @return
     */
    public static int minArray2(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int left = 0;
        int right = numbers.length - 1;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (numbers[middle] < numbers[right]) {
                right = middle;
            } else if (numbers[middle] > numbers[right]) {
                left = middle + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] array = {2, 2, 2, 0, 1};
        System.out.println(minArray2(array));
    }
}
