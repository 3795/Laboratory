package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 最长公共前缀
 * Created At 2019/01/20
 */
public class Exercise14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder result = new StringBuilder();
        for (int index=0; index<strs[0].length(); index ++) {
            char c = strs[0].charAt(index);
            for (int i=1; i<strs.length; i++) {
                if (index >= strs[i].length() || (c != strs[i].charAt(index))) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] s = {"","", ""};
        System.out.println(longestCommonPrefix(s));
    }
}
