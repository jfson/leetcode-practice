package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/10/29
 * Question:  766. Toeplitz Matrix
 * Description:
 * Train of thought:
 */
public class EasyLc766 {

    /**

     [1,2,3,4],
     [5,1,2,3],
     [9,5,1,2]

     "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".  true


     [1,2],
     [2,2]

     The diagonal "[1, 2]" has different elements. False

     思路 下一行的下一列要相等
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return false;

        int line = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < line - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (matrix[i][j] != matrix[i+1][j+1]) return false;
            }
        }

        return true;
    }
}
