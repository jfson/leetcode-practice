package com.sun.leetcode.differentkind.backtracking;

/**
 * Author: jfson sun
 * Create on:  2018/11/28
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMedium79 {
    /**
     * 79. Word Search
     * Given a 2D board and a word, find if the word exists in the grid.
     * <p>
     * The word can be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     * <p>
     * Example:
     * <p>
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     * <p>
     * 题意：2维数组中可以拼成单词，每个字符只能用一次。所有字符需要相连
     * solution: 枚举并进行深度优先搜索
     */

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) return false;

        int x = board.length;
        int y = board[0].length;
        boolean[][] visit = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (search(board, visit, i, j, 0, words)) return true;
            }
        }


        return false;
    }


    public boolean search(char[][] board, boolean[][] visit, int startX, int startY, int step, char[] words) {
        if (step == words.length) {
            return true;
        }

        if (startX < 0 || startY < 0 || startX == board.length || startY == board[0].length) {
            return false;
        }

        if (visit[startX][startY]) {
            return false;
        }

        if (words[step] != board[startX][startY]) {
            return false;
        }

        visit[startX][startY] = true;
        boolean isOk =  search(board, visit, startX, startY + 1, step + 1, words) ||
                        search(board, visit, startX, startY - 1, step + 1, words) ||
                        search(board, visit, startX + 1, startY, step + 1, words) ||
                        search(board, visit, startX - 1, startY, step + 1, words);
        visit[startX][startY] = false;// 回溯
        return isOk;
    }
}
