package com.sun.leetcode.differentkind.array;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/10/31
 * Question:   169. Majority Element
 * Description:
 * Train of thought:
 */
public class EasyLc169 {
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     */


    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
