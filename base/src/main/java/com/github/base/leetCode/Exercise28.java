package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 实现strStr()
 * Created At 2019/01/23
 */
public class Exercise28 {
    public static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }

        if ("".equals(needle)) {
            return 0;
        }

        int length = needle.length();
        for (int i=0; i<haystack.length(); i++) {
            if (i + length <= haystack.length() && haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i+length).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaa", "aaaaa"));
    }

}
