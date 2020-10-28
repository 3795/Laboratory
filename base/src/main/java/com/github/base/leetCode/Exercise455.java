package com.github.base.leetCode;

import java.util.Arrays;

/**
 * Created By Seven.wk
 * Description: 分发饼干，贪心算法实现
 * Created At 2019/01/18
 */
public class Exercise455 {

    public int findContentChildren(int[] g, int[] s) {
        // 将两个数组进行升序排列
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1;
        int si = s.length - 1;
        int res = 0;
        while (gi >=0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res ++;
                si --;
            }
            gi --;
        }
        return res;
    }

    public static void main(String[] args) {
        int g1[] = {1, 2, 3};
        int s1[] = {1, 1};
        System.out.println((new Exercise455()).findContentChildren(g1, s1));
    }
}
