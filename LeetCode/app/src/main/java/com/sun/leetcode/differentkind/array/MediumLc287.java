package com.sun.leetcode.differentkind.array;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/11/4
 * Question:Find the Duplicate Number
 * Description:
 * Train of thought:
 */
public class MediumLc287 {

    /**
     Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

     Example 1:

     Input: [1,3,4,2,2]
     Output: 2
     Example 2:

     Input: [3,1,3,4,2]
     Output: 3
     Note:

     You must not modify the array (assume the array is read only).
     You must use only constant, O(1) extra space.
     Your runtime complexity should be less than O(n2).
     There is only one duplicate number in the array, but it could be repeated more than once.

     solution 1:
     先排序，前后一致则return. /Time complexity : O(nlgn)/Space complexity : O(1) (or O(n))

     solution 2:
        存 set..已经存在则return.Time complexity : O(n)  Space complexity : O(n)
     */

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        if (nums == null || nums.length == 0) return 0;

        for (int i = 1;i<nums.length;i++){
            if (nums[i] == nums[i-1]) return nums[i];
        }

        return 0;
    }
}
