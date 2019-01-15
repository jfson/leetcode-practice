package com.sun.leetcode.difficulty.easy;

import android.util.Log;

/**
 * Author: jfson sun
 * Create on:  2018/9/25
 * Question: 26. Remove Duplicates from Sorted Array
 * Description: Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Train of thought: 复杂度O(1) ,只能通过索引来做，索引比较值，不相同则++。
 */
public class LeetCode26 {

    /**
     26. Remove Duplicates from Sorted Array
     Easy

     Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

     Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

     Example 1:

     Given nums = [1,1,2],

     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

     It doesn't matter what you leave beyond the returned length.
     Example 2:

     Given nums = [0,0,1,1,1,2,2,3,3,4],

     Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

     It doesn't matter what values are set beyond the returned length.
     题意：返回移除重复元素后数组的长度

     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            Log.i("removeDuplicates","j:" + j +"-- i:" + i);
            if (nums[j] != nums[i]) {
                // j 计数+1，数组值在前，改了也无妨 // ++j 为下一次j
                nums[++j] = nums[i];
                Log.i("removeDuplicates j--:","j:" + j +"-- i:" + i);
            }
        }

        return ++j;
    }
}
