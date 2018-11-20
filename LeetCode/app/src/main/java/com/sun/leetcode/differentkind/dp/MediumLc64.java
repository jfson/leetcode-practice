package com.sun.leetcode.differentkind.dp;

/**
 * Author: jfson sun
 * Create on:  2018/11/20
 * Description:
 */
public class MediumLc64 {
    /**
     * 64. Minimum Path Sum
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     * <p>
     * Note: You can only move either down or right at any point in time.
     * <p>
     * Example:
     * <p>
     * Input:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     * solution: DP
     */

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] ret = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    ret[0][0] += grid[0][0];
                } else if (i == 0) {
                    ret[i][j] = grid[i][j] + ret[i][j - 1];
                } else if (j == 0) {
                    ret[i][j] = grid[i][j] + ret[i - 1][j];
                } else {
                    ret[i][j] += grid[i][j] + Math.min(ret[i - 1][j], ret[i][j - 1]);
                }
            }
        }

        return ret[grid.length-1][grid[0].length-1];
    }
}
