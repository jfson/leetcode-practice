package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2019/1/15
 * Question:
 * Description:
 * Train of thought:
 */
public class LeetCode219 {
    /**
     219. Contains Duplicate II

     Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

     Example 1:

     Input: nums = [1,2,3,1], k = 3
     Output: true
     Example 2:

     Input: nums = [1,0,1,1], k = 1
     Output: true
     Example 3:

     Input: nums = [1,2,3,1,2,3], k = 2
     Output: false

     题意：两个相同元素间索引差小于k
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return false;

        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1; j < nums.length;j++){
                if(nums[i] == nums[j] && j - i <= k){
                    return true;
                }
            }
        }
        return false;
    }
}
