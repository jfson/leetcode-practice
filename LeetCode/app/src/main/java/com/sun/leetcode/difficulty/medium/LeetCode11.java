package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/5
 * Question:    11. Container With Most Water
 * Description:
 * Train of thought:
 */
public class LeetCode11 {

    /**
     11. Container With Most Water
     Medium
     Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

     Note: You may not slant the container and n is at least 2.





     The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



     Example:

     Input: [1,8,6,2,5,4,8,3,7]
     Output: 49
     题意： 最大的盛水面积
     */
    public int maxArea(int[] height) {
        int max = 0;
        if (height == null || height.length == 0) return 0;

        for (int i = 0; i < height.length -1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int current = (j-i) * Math.min(height[i],height[j]);
                max = Math.max(current,max);
            }
        }


        return max;
    }
}
