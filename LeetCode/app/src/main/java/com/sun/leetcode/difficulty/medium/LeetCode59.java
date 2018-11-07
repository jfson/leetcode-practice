package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/11
 * Question: 59. Spiral Matrix II
 * Description: Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * Train of thought:
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return res;

        helper(n, res);
        return res;
    }


    void helper(int n, int[][] res) {
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;

        int num = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // left to right
            for (int i = colStart; i <= rowEnd; i++) {
                res[rowStart][i] = num++;
            }

            rowStart++;


            // right -> bottom
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = num++;
            }
            colEnd--;


            // bottom--> left

            for (int i = colEnd; i >= colStart; i--) {
                res[rowEnd][i] = num++;
            }
            rowEnd--;

            // left-- top
            for (int i = colEnd; i >= rowStart; i--) {
                res[i][colStart] = num++;
            }
            colStart++;
        }
    }
}
