package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 盛最多水的容器
 * Created At 2019/01/29
 */
public class Exercise11 {

    public static int maxArea(int[] height) {

        if (height.length < 2) {
            return 0;
        }

        int max = 0, tmp;
        int i = 0, j = height.length - 1;
        while (i < j) {
            tmp = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(tmp, max);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }

    public static int maxAreaB(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int max = 0, tmp;
        for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length; j++) {
                tmp = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(tmp, max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
