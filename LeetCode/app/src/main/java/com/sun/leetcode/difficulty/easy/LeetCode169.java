package com.sun.leetcode.difficulty.easy;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/10/3
 * Question:    169. Majority Element
 * Description: Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Train of thought:
 */
public class LeetCode169 {


    // 最多出现的数，次数大于n/2//那么排序后，中间那个数肯定是
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
