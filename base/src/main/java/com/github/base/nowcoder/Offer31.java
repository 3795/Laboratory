package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 求出任意非负整数区间中1出现的次数
 * Created At 2019/01/26
 */
public class Offer31 {

    public static int solution(int n) {
        int count = 0;
        int tmp;
        for (int i=0; i<=n; i++) {
            tmp = i;
            while (tmp > 0) {
                if (tmp%10 == 1) {
                    count ++;
                }
                tmp /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(13));
    }

}
