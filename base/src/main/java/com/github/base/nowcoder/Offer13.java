package com.github.base.nowcoder;

import java.util.ArrayList;

/**
 * Created By Seven.wk
 * Description: 调整数组顺序使奇数位于偶数前面
 * Created At 2019/02/24
 */
public class Offer13 {

    /**
     * 方法一，使用冒泡排序的思想，相邻的奇数与偶数交换位置
     * @param array
     */
    public static void reOrderArray(int [] array) {
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array.length-1-i; j++) {
                if (array[j]%2==0 && array[j+1]%2 == 1) {
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }

    /**
     * 方法二，使用插入排序的方式
     * @param array
     */
    public static void reOrderArrayB(int[] array) {
        for (int i=0; i<array.length; i++) {
            for (int j=i; j>0; j--) {
                if (array[j]%2 == 1 && array[j-1]%2 == 0) {
                    int t = array[j];
                    array[j] = array[j-1];
                    array[j-1] = t;
                }
            }
        }
    }

    /**
     * 方法三，使用额外的空间
     * @param array
     */
    public static void reOrderArrayC(int[] array) {
        ArrayList<Integer> oddNumberList = new ArrayList<>();        // 奇数列表
        ArrayList<Integer> evenList = new ArrayList<>();     // 偶数列表
        for (int i : array) {
            if (i%2 == 1) {
                oddNumberList.add(i);
            } else {
                evenList.add(i);
            }
        }

        for (int i=0; i<oddNumberList.size(); i++) {
            array[i] = oddNumberList.get(i);
        }

        for (int i=oddNumberList.size(); i<array.length; i++) {
            array[i] = evenList.get(i-oddNumberList.size());
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 7, 2, 4, 9, 3, 1};
//        reOrderArray(arr);
//        reOrderArrayB(arr);
        reOrderArrayC(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
