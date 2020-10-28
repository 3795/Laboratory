package com.github.base.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 顺时针打印矩阵
 * Created At 2019/02/27
 */
public class Offer19 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix.length < 1) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        int count = 1;

        int up = 0, left = 0;
        int down = row;
        int right = col;

        int i = 0, j = 0;

        // 0为上边，1为右边，2为下边，3为左边
        int direction = 0;

        while (count <= total) {

            // 上边界向右走
            if (direction == 0) {
                if (j < right) {
                    list.add(matrix[i][j]);
                    count ++;
                    j++;
                } else {
                    j = right - 1;
                    i ++;
                    direction = 1;
                    up += 1;
                }
            }

            // 右边界向下走
            if (direction == 1) {
                if (i < down) {
                    list.add(matrix[i][j]);
                    count++;
                    i++;
                } else {
                    i = down - 1;
                    j--;
                    right -= 1;
                    direction = 2;
                }
            }

            // 下边界向左走
            if (direction == 2) {
                if (j >= left) {
                    list.add(matrix[i][j]);
                    count++;
                    j--;
                } else {
                    j = left;
                    i--;
                    down -= 1;
                    direction = 3;
                }
            }

            // 左边界向上走
            if (direction == 3) {
                if (i >= up) {
                    list.add(matrix[i][j]);
                    count++;
                    i--;
                } else {
                    i = up;
                    j++;
                    left += 1;
                    direction = 0;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        List<Integer> result = printMatrix(arr);
        result.forEach(e -> {
            System.out.print(e + " ");
        });
    }
}
