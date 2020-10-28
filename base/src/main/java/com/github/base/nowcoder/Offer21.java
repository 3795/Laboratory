package com.github.base.nowcoder;

import java.util.ArrayList;

/**
 * Created By Q.Hao
 * Description: 栈的压入，弹出顺序
 * Created At 2019/03/01
 */
public class Offer21 {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null) {
            return false;
        }

        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (j < popA.length && i < pushA.length) {
            if (pushA[i] == popA[j]) {
                i++;
                j++;
            } else {
                list.add(pushA[i]);
                i++;
            }
        }

        i = list.size();
        while (i > 0 && j < popA.length) {
            if (popA[j] != list.get(i-1)) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(pushA, popA));
    }

}
