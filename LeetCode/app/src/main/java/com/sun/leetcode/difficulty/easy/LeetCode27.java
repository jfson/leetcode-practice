package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/9/26
 * Question:  Remove Element
 * Description: Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Train of thought: 其实就是计数外，find 后移到最后面..交换j索引给非重复的元素即可
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                continue;
            }

            nums[j] = nums[i];
            j++;
        }

        return j;
    }
}
