package com.github.base.leetCode;

import java.util.Stack;

/**
 * Created By Seven.wk
 * Description: 有效的括号
 * Created At 2018/12/26
 */
public class Exercise20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // 如果当前字符是以下三种情况，则入栈
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                // 反之，进行出栈匹配

                if (stack.size() == 0) {
                    return false;
                }

                char match;
                switch (c) {
                    case '}':
                        match = '{'; break;
                    case ']':
                        match = '['; break;
                    case ')':
                        match = '('; break;
                    default:
                        match = '(';
                }

                if (match != stack.pop()) {
                    return false;
                }
            }
        }

        // 对字符串进行遍历处理后，栈不为空的话，则说明也是不合法的
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "{[]";
        System.out.println(isValid(s));
    }
}
