package com.github.base.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 电话号码的字母组合
 * Created At 2019/01/03
 */
public class Exercise17 {

    private String[] letterMap = {
            " ",      // 0
            "",     // 1
            "abc",      // 2
            "def",      // 3
            "ghi",      // 4
            "jkl",      // 5
            "mno",      // 6
            "pqrs",     // 7
            "tuv",      // 8
            "wxyz"      // 9
    };

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || "".equals(digits)) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    /**
     * 进行字符串的组合
     * @param digits
     * @param index
     * @param s
     */
    private void findCombination(String digits, int index, String s) {

        // 递归终止条件
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i<letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        List<String> result = new Exercise17().letterCombinations("23");
        result.forEach(System.out::println);
    }

}
