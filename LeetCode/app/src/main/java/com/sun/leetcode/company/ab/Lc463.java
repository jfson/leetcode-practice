package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2019/1/12
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc463 {
    /**
     You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

     Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
     and there is exactly one island (i.e., one or more connected land cells).

     The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
     One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.


     Example:

     Input:
     [[0,1,0,0],
     [1,1,1,0],
     [0,1,0,0],
     [1,1,0,0]]

     Output: 16

     Explanation: The perimeter is the 16 yellow stripes in the image below:

     题意： 计算岛的周长
     */

    public int islandPerimeter(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        int ans = 0;
        for (int i = 0;i<N;i++){
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1){
                    ans += 4;

                    if (i > 0 && grid[i-1][j] == 1) ans -= 2;
                    if (j > 0 && grid[i][j-1] == 1) ans -= 2;
                }
            }
        }


        return ans;
    }

}
