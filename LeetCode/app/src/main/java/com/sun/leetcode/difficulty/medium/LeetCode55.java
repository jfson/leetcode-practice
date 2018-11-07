package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/11
 * Question:    55. Jump Game
 * Description:Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Train of thought:
 */
public class LeetCode55 {

    // 贪心算法
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;

        int maxIndext = 0;

        for (int i = 0; i < nums.length && i <= maxIndext; i++) {
            maxIndext = Math.max(maxIndext, i + nums[i]);

            if (maxIndext >= nums.length - 1) return true;
        }

        return false;
    }
}
