package com.github.base.offer;

/**
 * 矩阵中的路径
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
 */
public class Offer12 {

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 这个双循环是指，从数组中的每个点为起始点，依次做尝试
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 对明确不通的道路进行剪枝
        if (i >= board.length || i < 0
                || j >= board[0].length || j < 0
                || word[k] != board[i][j]) {
            return false;
        }

        // 递归终止条件
        if (k == word.length - 1) {
            return true;
        }

        board[i][j] = '\0';     // 表明这个点已经访问过了
        // 访问该匹配点的上下左右四个点，进行深度优先递归
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];      // 本次搜寻结束，将访问过的点恢复原样，避免影响到其他的路径搜寻
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }
}
