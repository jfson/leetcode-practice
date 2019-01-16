package com.sun.leetcode.difficulty.easy;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    136. Single Number
 * Description: Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Train of thought:
 */
public class LeetCode136 {
    /**
     136. Single Number
     Easy

     Given a non-empty array of integers, every element appears twice except for one. Find that single one.

     Note:

     Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

     Example 1:

     Input: [2,2,1]
     Output: 1
     Example 2:

     Input: [4,1,2,1,2]
     Output: 4
     找出落单的那个
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // 先排序,两两不相等
        Arrays.sort(nums);
//        [1,1,2,2,3,3,4,5,5,6,6]

        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        for (int i = 1; i < nums.length - 3; i++) {
            if (nums[i] != nums[i + 1] && nums[i + 1] != nums[i + 2]) {
                return nums[i + 1];
            }
        }

        return 0;
    }
}
