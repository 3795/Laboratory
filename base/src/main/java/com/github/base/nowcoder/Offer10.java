package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 矩形覆盖
 * 其实质依然是斐波那契数列
 * Created At 2019/02/22
 */
public class Offer10 {

    /**
     * 递归法实现
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        } else {
            return RectCover(target - 1) + RectCover(target-2);
        }
    }

    public int RectCoverB(int target) {
        int[] memo = new int[target + 1];
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        }
        memo[1] = 1;
        memo[2] = 2;

        for (int i=3; i<=target; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[target];
    }

    public static void main(String[] args) {
//        System.out.println(new Offer10().RectCover(3));
        System.out.println(new Offer10().RectCoverB(2));
    }

}
