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

    // when  removeDuplicates(new int[]{1,1,1,2,3,4,5,5,8}) logs:
//    removeDuplicates: j:0-- i:0
//    removeDuplicates: j:0-- i:1
//    removeDuplicates: j:0-- i:2
//    removeDuplicates: j:0-- i:3
//    removeDuplicates j--:: j:1-- i:3
//    removeDuplicates: j:1-- i:4
//    removeDuplicates j--:: j:2-- i:4
//    removeDuplicates: j:2-- i:5
//    removeDuplicates j--:: j:3-- i:5
//    removeDuplicates: j:3-- i:6
//    removeDuplicates j--:: j:4-- i:6
//    removeDuplicates: j:4-- i:7
//    removeDuplicates: j:4-- i:8
//    removeDuplicates j--:: j:5-- i:8

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
