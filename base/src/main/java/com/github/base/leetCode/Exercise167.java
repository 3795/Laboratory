package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 两数之和 II - 输入有序数组
 * Created At 2019/01/26
 */
public class Exercise167 {
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] result = new int[2];
        while(l < r) {
            if (numbers[l] + numbers[r] == target) {
                result[0] = l+1;
                result[1] = r+1;
                return result;
            } else if (numbers[l] + numbers[r] < target) {
                l ++;
            } else {
                r --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int[] result = twoSum(numbers, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
