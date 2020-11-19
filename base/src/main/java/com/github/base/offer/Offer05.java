package com.github.base.offer;


/**
 * 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class Offer05 {

    /**
     * 解法1：直接调用API
     *
     * @param s
     * @return
     */
    public static String replaceSpace1(String s) {
        s = s.replaceAll(" ", "%20");
        return s;
    }

    /**
     * 解法2：构造一个新的字符串方式
     * 在Java中，String被设计成了不可变类型，所以只能手动构造出一个新的字符串
     * 时间复杂度：O(n)，空间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public static String replaceSpace2(String s) {
        int length = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (' ' == c) {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace2("We are happy."));
    }
}
