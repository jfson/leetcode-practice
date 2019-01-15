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
    /**
     27. Remove Element
     Easy

     Given an array nums and a value val, remove all instances of that value in-place and return the new length.

     Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

     The order of elements can be changed. It doesn't matter what you leave beyond the new length.

     Example 1:

     Given nums = [3,2,2,3], val = 3,

     Your function should return length = 2, with the first two elements of nums being 2.

     It doesn't matter what you leave beyond the returned length.
     Example 2:

     Given nums = [0,1,2,2,3,0,4,2], val = 2,

     Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

     Note that the order of those five elements can be arbitrary.

     It doesn't matter what values are set beyond the returned length.

     其实就是计数外，find 后移到val最后面..交换j索引给非重复的元素即可
     */
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
