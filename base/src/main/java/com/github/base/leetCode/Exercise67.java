package com.github.base.leetCode;

/**
 * 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 */
public class Exercise67 {

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i=a.length() - 1, j=b.length()-1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            // 判断j>=0的含义是有可能两个数字长度不一致，如果j<0的话则将其当做0来处理，否则获取其值，也就是 b.charAt(j) - '0'
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            // 取模运算
            ans.append(sum % 2);
            // 计算进位，满2进1
            ca = sum / 2;
        }
        // 判断最后是否还有进位
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Exercise67().addBinary("1010", "1011"));
    }
}
