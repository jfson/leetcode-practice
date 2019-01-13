package com.sun.leetcode.difficulty.medium;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/10/5
 * Question:    3Sum Closest
 * Description:
 * Train of thought:
 */
public class LeetCode16 {
    /**
     16. 3Sum Closest
     Medium
     Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

     Example:

     Given array nums = [-1, 2, 1, -4], and target = 1.

     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */

    int closeNum = 0;

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);
        closeNum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            findCloseNum(nums, i, i + 1, nums.length - 1, target);
        }

        return closeNum;
    }

    void findCloseNum(int[] nums, int current, int start, int end, int target) {

        while (start < end) {
            int sum = nums[start] + nums[end] + nums[current];

            if (Math.abs(target - closeNum) > Math.abs(target - sum)) {
                closeNum = sum;
            }

            if (sum == target) {
                closeNum = sum;
                return;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
    }

}
