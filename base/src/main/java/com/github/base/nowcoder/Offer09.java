package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 变态跳台阶
 * Created At 2019/02/22
 */
public class Offer09 {

    /**
     * 变态跳台阶
     * 推理数据关系可知：f(n) = 2*f(n-1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {

        if (target < 1) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2*JumpFloorII(target - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offer09().JumpFloorII(3));
    }

}
