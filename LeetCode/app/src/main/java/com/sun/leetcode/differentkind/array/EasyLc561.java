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


    // 先sort
    // 每2个取i值即可
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
