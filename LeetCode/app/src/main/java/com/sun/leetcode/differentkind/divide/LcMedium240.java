package com.sun.leetcode.differentkind.divide;

/**
 * Author: jfson sun
 * Create on:  2018/11/29
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMedium240 {
    /**
     240. Search a 2D Matrix II
     DescriptionHintsSubmissionsDiscussSolution
     Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

     Integers in each row are sorted in ascending from left to right.
     Integers in each column are sorted in ascending from top to bottom.
     Example:

     Consider the following matrix:

     [
     [1,   4,  7, 11, 15],
     [2,   5,  8, 12, 19],
     [3,   6,  9, 16, 22],
     [10, 13, 14, 17, 24],
     [18, 21, 23, 26, 30]
     ]
     Given target = 5, return true.

     Given target = 20, return false.
     题意：找到这个值
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int row = matrix.length-1;
        int col = 0;

        while (row >=0 && col < matrix[0].length){
            if (matrix[row][col] >target){
                row--;
            }else if (matrix[row][col] < target){
                col++;
            }else {
                return true;
            }
        }
        return false;
    }
}
