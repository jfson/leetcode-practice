package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/9/26
 * Question: Search Insert Position
 * Description: Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * Train of thought:
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            } else {
                ret = i + 1;
            }
        }

        return ret;
    }
}
