package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2019/8/12
 * Question:
 * Description:
 * Train of thought:
 */
public class MediumLc73 {
    /**
     73. Set Matrix Zeroes

     Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

     题意：位置为0的尾椎，他的横竖轴也填充为0。
     题解：第一遍遍历首先将0的位置标记出来（横竖轴），第二遍遍历则将横竖轴标记为0
     */
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }

        int[] m = new int[matrix.length];
        int[] n = new int[matrix[0].length];

        for(int i = 0;i < m.length ;i++){
            for(int j = 0;j < n.length ;j++){
                if(matrix[i][j] == 0){
                    m[i] = 1;
                    n[j] = 1;
                }
            }
        }

        for(int i = 0;i < m.length ;i++){
            for(int j = 0;j < n.length ;j++){
                if(m[i] == 1 || n[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
