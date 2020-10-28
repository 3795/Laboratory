package com.github.base.leetCode;

/**
 * Created By Seven.wk
 * Description: 单词搜索
 * Created At 2019/01/18
 */
public class Exercise79 {

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int x, int y) {

        // 递归终止条件
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }

        if (board[x][y] == word.charAt(index)) {
            // 该元素已被使用
            visited[x][y] = true;
            // 从该点出发，向四个方向搜索
            for (int i=0; i<4; i++) {
                int newx = x + d[i][0];
                int newy = y + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy]) {
                    if (searchWord(board, word, index+1, newx, newy)) {
                        return true;
                    }
                }
            }

            // 回溯
            visited[x][y] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x>=0 && x<m && y >=0 && y<n;
    }

    public static void main(String args[]){

        char[][] b1 = { {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        String words[] = {"ABCCED", "SEE", "ABCB" };
        for(int i = 0 ; i < words.length ; i ++)
            if((new Exercise79()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);

        // ---

        char[][] b2 = {{'A'}};
        if((new Exercise79()).exist(b2,"AB"))
            System.out.println("found AB");
        else
            System.out.println("can not found AB");
    }
}
