package com.sun.leetcode.company.li;

/**
 * Author: jfson sun
 * Create on:  2019/5/3
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc256 {
    /**
     256. Paint House
     Easy

     There are a row of n houses, each house can be painted with one of the three colors:
     red, blue or green. The cost of painting each house with a certain color is different.
     You have to paint all the houses such that no two adjacent houses have the same color.

     The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
     For example, costs[0][0] is the cost of painting house 0 with color red;
     costs[1][2] is the cost of painting house 1 with color green, and so on...
     Find the minimum cost to paint all houses.

     Note:
     All costs are positive integers.

     Example:

     Input: [[17,2,17],[16,16,5],[14,3,19]]
     Output: 10
     Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
     Minimum cost: 2 + 5 + 3 = 10.
     题意：每个子数组标识（RGB）花费的费用。求花费最小的房子。用dp.当前如果是红色，相邻的蓝色或者绿色中的花费取最小值
     solution:dp
     */

    /**
     17    2    17
     16    16    5
     14    3    19
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0){
            return 0;
        }

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }

        int n = costs.length -1;

        return Math.min(Math.min(costs[n][0],costs[n][1]),costs[n][2]);
    }
}
