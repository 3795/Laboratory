package com.github.base.offer;

/**
 * 顺时针打印数组
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class Offer29 {

    /**
     * 时间复杂度：O(mn)；空间复杂度：O(mn)
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int top = 0;
        int left = 0;
        int[] result = new int[matrix[0].length * matrix.length];
        int idx = 0;
        while (true) {
            //从左往右走
            for (int i = left; i <= right; i++) {
                result[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            //从上往下走
            for (int i = top; i <= bottom; i++) {
                result[idx++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            //从右往左走
            for (int i = right; i >= left; i--) {
                result[idx++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            //从下往上走
            for (int i = bottom; i >= top; i--) {
                result[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[] result = spiralOrder(matrix);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
