package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/5
 * Question:    11. Container With Most Water
 * Description:
 * Train of thought:
 */
public class LeetCode11 {

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
