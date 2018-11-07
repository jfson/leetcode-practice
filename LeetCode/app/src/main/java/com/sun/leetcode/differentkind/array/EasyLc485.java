package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/10/30
 * Question:    485. Max Consecutive Ones
 * Description: Given a binary array, find the maximum number of consecutive 1s in this array.
 * Train of thought:
 */
public class EasyLc485 {

    /**
     * Input: [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s.
     * The maximum number of consecutive 1s is 3.
     * 本题的题意为找到最多连续1的个数
     */

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxHere = 0,max = 0;
        for (int num : nums) {
            max = Math.max(max,maxHere = num == 0? 0:maxHere+1);
        }
        return max;
    }

}
