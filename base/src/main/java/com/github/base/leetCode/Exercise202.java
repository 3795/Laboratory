package com.github.base.leetCode;

/**
 * 快乐数
 * 链接：https://leetcode-cn.com/problems/happy-number
 */
public class Exercise202 {

    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int slow = n;       // 慢指针
        int fast = n;       // 快指针
        do {
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    public int sum(int n) {
        int last;
        int count = 0;
        while(n > 0) {
            last = n % 10;
            n /= 10;
            count += last * last;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Exercise202().isHappy(7));
//        System.out.println(new Exercise202().sum(7));
//        System.out.println(1%10);
    }

}
