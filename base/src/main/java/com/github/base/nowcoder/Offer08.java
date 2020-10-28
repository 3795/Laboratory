package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 跳台阶
 * Created At 2019/02/22
 */
public class Offer08 {

    /**
     * 跳台阶递归实现
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        if (target < 1) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return jumpFloor(target-1) + jumpFloor(target-2);
        }
    }

    /**
     * 跳台阶动态规划实现
     * @param target
     * @return
     */
    public static int jumpFloorB(int target) {
        if (target < 1) {
            return -1;
        }

        if (target == 1 || target == 2) {
            return target;
        }

        int[] memo = new int[target + 1];
        memo[1] = 1;
        memo[2] = 2;

        for (int i=3; i<=target; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[target];
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(20));
        System.out.println(jumpFloorB(20));
    }
}
