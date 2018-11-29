package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/11/29
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMediun74 {
    /**
     * 74. Search a 2D Matrix
     * DescriptionHintsSubmissionsDiscussSolution
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * <p>
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * Example 1:
     * <p>
     * Input:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 3
     * Output: true
     * Example 2:
     * <p>
     * Input:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 13
     * Output: false
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0;
        int col = matrix[0].length-1;

        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] < target){
                row++;
            }else {
                col--;
            }
        }

        return false;
    }
}
