package com.github.base.leetCode;

import java.util.Arrays;

/**
 * 最后一块石头的重量
 * https://leetcode-cn.com/problems/last-stone-weight/
 */
public class Exercise1046 {

    public int lastStoneWeight(int[] stones) {
        int weight;
        int length = stones.length;
        for (int i=0; i<length-1; i++) {
            Arrays.sort(stones);
            weight = stones[length-1] - stones[length-2];
            stones[length-1] = weight;
            stones[length-2] = 0;
        }
        return stones[length-1];
    }

    public static void main(String[] args) {
        int[] stones = {1, 1, 2, 3};
        int result = new Exercise1046().lastStoneWeight(stones);
        System.out.println(result);
    }
}
