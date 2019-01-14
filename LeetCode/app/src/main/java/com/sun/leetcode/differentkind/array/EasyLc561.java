package com.sun.leetcode.differentkind.array;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/10/29
 * Question: 561.
 * Description:
 * Train of thought:
 */
public class EasyLc561 {
    /**
     561. Array Partition I

     Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

     Example 1:
     Input: [1,4,3,2]

     Output: 4
     Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     Note:
     n is a positive integer, which is in the range of [1, 10000].
     All the integers in the array will be in the range of [-10000, 10000].
     题意：排序拆分

      先sort
     每2个取i值即可
     */


    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int ret = 0;
        for(int i = 0;i<nums.length;i = i+2){
            ret += nums[i];
        }

        return ret;
    }
}
