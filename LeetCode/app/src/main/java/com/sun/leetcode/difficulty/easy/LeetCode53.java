package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/9/27
 * Question:    53. Maximum Subarray
 * Description: Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Train of thought: 变小则不加。。变大则重新赋值。。
 */
public class LeetCode53 {
    // 动态规划 & 分治
    // O(n)
    //    Input: [-2,1,-3,4,-1,2,1,-5,4],
    //    Output: 6
    //    Explanation: [4,-1,2,1] has the largest sum = 6.
    // 选或者不选

    /**
     53. Maximum Subarray
     Easy

     Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

     Example:

     Input: [-2,1,-3,4,-1,2,1,-5,4],
     Output: 6
     Explanation: [4,-1,2,1] has the largest sum = 6.
     Follow up:

     If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     题意：寻找最大的连续和
     变小则不加。。变大则重新赋值。。
     */

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return -1;

        int sum = 0, maxNum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxNum) maxNum = sum;

            if (sum < 0) sum = 0;
        }

        return maxNum;
    }
}
