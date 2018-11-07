package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/16
 * Question:    63. Unique Paths II
 * Description:
 * Train of thought:
 */
public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;

        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;

        for (int[] row : obstacleGrid) {
            for (int i = 0; i < width; i++) {
                if (row[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i-1];
                }
            }

        }

        return dp[width-1];
    }
}
