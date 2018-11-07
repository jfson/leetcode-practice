package com.sun.leetcode.difficulty.medium;

import java.util.HashSet;

/**
 * Author: jfson sun
 * Create on:  2018/10/7
 * Question:    36. Valid Sudoku
 * Description:
 * Train of thought:
 */
public class LeetCode36 {

    public boolean isValidSudoku(char[][] board) {


        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> grid = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // i row  , some item is already in set,it will be return false when you add()
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;

                // j column
                if (board[j][i] != '.' && !column.add(board[j][i])) return false;

                // grid
                int gridRow = 3 * (i / 3) + j / 3; // 行 + 偏移
                int gridColumn = 3 * (i % 3) + j % 3; // 列 + 偏移
                if (board[gridRow][gridColumn] != '.' && !grid.add(board[gridRow][gridColumn]))
                    return false;
            }
        }

        return true;
    }
}
