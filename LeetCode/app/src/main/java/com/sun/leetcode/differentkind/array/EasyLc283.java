package com.sun.leetcode.differentkind.array;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/10/30
 * Question:    283. Move Zeroes
 * Description:
 * Train of thought:
 */
public class EasyLc283 {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Example:
     * <p>
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     * <p>
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     * <p>
     * 题意：将元素 0 移动到最后面，并保持原有数据顺序
     *
     思路
     把这个数组中所有的 N 个非 0 元素全部都一一赋值给数组前 N 个元素位
     把数组中 N 个元素位之后的元素全部赋值为 0

     */

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }

        for (;j<nums.length;j++){
            nums[j] = 0;
        }
    }
}
