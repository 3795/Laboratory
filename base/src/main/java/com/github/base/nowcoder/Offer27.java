package com.github.base.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created By Q.Hao
 * Description: 字符串的排列
 * Created At 2019/3/11
 */
public class Offer27 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    private void PermutationHelper(char[] cs, int i, ArrayList<String> res) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!res.contains(val)) {
                res.add(val);
            }
        } else {
            for (int j=i; j<cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, res);
                swap(cs, i, j);
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> res = new Offer27().Permutation(s);
        res.forEach(System.out::println);
    }
}
