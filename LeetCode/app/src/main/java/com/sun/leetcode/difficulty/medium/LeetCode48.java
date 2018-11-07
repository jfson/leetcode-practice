package com.sun.leetcode.difficulty.medium;

import android.util.Log;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/10/9
 * Question:48. Rotate Image
 * Description:
 * Train of thought: 只能swap
 */
public class LeetCode48 {
//    You are given an n x n 2D matrix representing an image.
//
//    Rotate the image by 90 degrees (clockwise).
//
//    Note:
//
//    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

    /**
     * Given input matrix =
     * [
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     */

    // first

/**
 * first left to right
 * Given input matrix =
 * [
 * [ 11, 9, 1,5],
 * [ 10, 8, 4,2],
 * [7, 6, 3, 13],
 * [16,12,14,15]
 *
 *  [0,1] [0,2]
 */

    /**
     * second 斜对角
     * Given input matrix =
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     * <p>
     * <p>
     * [0,1] --> [3,2]
     * <p>
     * <p>
     * 1,2,3
     * 4,5,6
     * 7,8,9
     * <p>
     * 321
     * 654
     */
    public void rotate(int[][] matrix) {
        /**
         *
         [ 5, 1, 9,11],
         [ 2, 4, 8,10],
         [13, 3, 6, 7],
         [15,14,12,16]

         ----

         [ 11, 9, 1, 5],
         [ 10, 8, 4, 2],
         [ 7 , 6, 3, 13],
         [ 16, 12, 14, 15]

         ----

         [15,13, 2, 5],
         [14, 3, 4, 1],
         [12, 6, 8, 9],
         [16, 7,10,11]

         0,1 --> 2,3
         */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = swap;
            }
        }

        Log.d("--->", "array:" + Arrays.toString(matrix));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - i; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][matrix[i].length - 1 - i];
                matrix[matrix.length - 1 - j][matrix[i].length - 1 - i] = swap;
            }
        }

        Log.d("--->", "array:" + Arrays.toString(matrix));
    }
}
