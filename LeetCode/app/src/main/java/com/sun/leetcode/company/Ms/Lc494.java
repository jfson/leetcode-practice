package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/3/26
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc494 {
    /**
     494. Target Sum
     Medium

     You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

     Find out how many ways to assign symbols to make sum of integers equal to target S.

     Example 1:
     Input: nums is [1, 1, 1, 1, 1], S is 3.
     Output: 5
     Explanation:

     -1+1+1+1+1 = 3
     +1-1+1+1+1 = 3
     +1+1-1+1+1 = 3
     +1+1+1-1+1 = 3
     +1+1+1+1-1 = 3

     There are 5 ways to assign symbols to make the sum of nums be target 3.
     Note:
     The length of the given array is positive and will not exceed 20.
     The sum of elements in the given array will not exceed 1000.
     Your output answer is guaranteed to be fitted in a 32-bit integer.

     题意： 有多少种组合值；只能使用+，-
     solution： 递归dfs
     */

    int total = 0;

    public int findTargetSumWays(int[] nums, int S) {
        helper(0, nums, 0, S);
        return total;
    }


    void helper(int idx, int nums[], int target, int s) {
        if (idx == nums.length && target == s) {
            total++;
            return;
        }
        if (idx >= nums.length) return;
        helper(idx + 1, nums, target + nums[idx], s);
        helper(idx + 1, nums, target - nums[idx], s);
    }

}
