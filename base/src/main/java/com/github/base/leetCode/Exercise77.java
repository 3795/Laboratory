package com.github.base.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 组合
 * Created At 2019/01/18
 */
public class Exercise77 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k < 0 || k > n) {
            return res;
        }

        LinkedList<Integer> c = new LinkedList<>();
        generateCombinations(n, k, 1, c);
        return res;
    }

    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c) {

        if (c.size() == k) {
            res.add((List<Integer>) c.clone());
            return;
        }

        for (int i = start; i <= n; i++) {
            c.addLast(i);
            generateCombinations(n, k, i+1, c);
            // 回溯，释放该元素
            c.removeLast();
        }
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Exercise77()).combine(4, 2);
        for(List<Integer> list: res)
            printList(list);
    }
}
