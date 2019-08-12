package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2019/8/12
 * Question:
 * Description:
 * Train of thought:
 */
public class MediumLc80 {
    /**
     80. Remove Duplicates from Sorted Array II

     Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

     Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

     Example 1:

     Given nums = [1,1,1,2,2,3],

     Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

     It doesn't matter what you leave beyond the returned length.
     Example 2:

     Given nums = [0,0,1,1,1,1,2,3,3],

     Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

     It doesn't matter what values are set beyond the returned length.

     题意：已经拍排序的数组。当一个元素重复超过2次时，移除重复的元素。并且将后续元素往前挪。返回当前长度。
     solution： 如果重复次数为1时，关键条件(i < 1 || num > nums[i-1])时，将元素前置即可。
                那么重复次数为2时。(i < 2 || num > nums[i-2])

     */

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        //sorted
        int i = 0;
        for(int num:nums){
            if(i < 2 || num > nums[i-2]){
                nums[i++] = num;
            }
        }

        return i;
    }
}
