package com.sun.leetcode.differentkind.dp;

/**
 * Author: jfson sun
 * Create on:  2019/1/15
 * Question:
 * Description:
 * Train of thought:
 */
public class EasyLc276 {
    /**
     276. Paint Fence
     Easy

     There is a fence with n posts, each post can be painted with one of the k colors.

     You have to paint all the posts such that no more than two adjacent fence posts have the same color.

     Return the total number of ways you can paint the fence.

     Note:
     n and k are non-negative integers.

     Example:

     Input: n = 3, k = 2
     Output: 6
     Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:

     post1  post2  post3
     -----      -----  -----  -----
     1         c1     c1     c2
     2         c1     c2     c1
     3         c1     c2     c2
     4         c2     c1     c1
     5         c2     c1     c2
     6         c2     c2     c1
     题意：有一个篱笆有n根柱子，每根柱子都可以涂上k种颜色中的一种。

     你必须油漆所有的柱子，使不超过两个相邻的栅栏柱子有相同的颜色。

     返回粉刷栅栏的方法总数。

     solution: DP
     */

    public int numWays(int n, int k) {
        if(n == 0) return 0;
        int diff[] = new int[n];
        int same[] = new int[n];

        same[0] = 0;
        diff[0] = k;

        for (int i = 1; i < n; i++) {
            same[i] = diff[i-1];
            diff[i] = (k-1) * same[i-1] + (k-1) * diff[i-1];
        }

        return same[n-1] + diff[n-1];
    }
}
