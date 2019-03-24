package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/3/24
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc62 {
    /**
     A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     The robot can only move either down or right at any point in time.
     The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     How many possible unique paths are there?

     Above is a 7 x 3 grid. How many possible unique paths are there?

     Note: m and n will be at most 100.

     Example 1:

     Input: m = 3, n = 2
     Output: 3
     Explanation:
     From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     1. Right -> Right -> Down
     2. Right -> Down -> Right
     3. Down -> Right -> Right
     Example 2:

     Input: m = 7, n = 3
     Output: 28

     用dp
     */
    public int uniquePaths(int m, int n) {
        // use dp
        if(m == 0 || n == 0) return 1;

        int[][] ret = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 || j == 0){
                    ret[i][j] = 1;
                    continue;
                }

                ret[i][j] = ret[i-1][j] + ret[i][j-1] ;
            }
        }

        return ret[m-1][n-1];
    }
}
