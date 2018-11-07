package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/14
 * Question:    62. Unique Paths
 * Description:
 * Train of thought:
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n ==0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[m][n];

        // 只有一行时
//        for (int i = 0; i < n; i++) {
//            dp[0][i] = 1;
//        }
//
//        // 只有一列时
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//        }
//
//        // for each body node, number of path = paths from top + paths from left
//        for (int i = 0; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i-1][j]+dp[i][j-1];
//            }
//        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i==0||j==0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
}
