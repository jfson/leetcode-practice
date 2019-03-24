package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/3/24
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc189 {
    /**
     189. Rotate Array
     Easy

     Given an array, rotate the array to the right by k steps, where k is non-negative.

     Example 1:

     Input: [1,2,3,4,5,6,7] and k = 3
     Output: [5,6,7,1,2,3,4]
     Explanation:
     rotate 1 steps to the right: [7,1,2,3,4,5,6]
     rotate 2 steps to the right: [6,7,1,2,3,4,5]
     rotate 3 steps to the right: [5,6,7,1,2,3,4]
     Example 2:

     Input: [-1,-100,3,99] and k = 2
     Output: [3,99,-1,-100]
     Explanation:
     rotate 1 steps to the right: [99,-1,-100,3]
     rotate 2 steps to the right: [3,99,-1,-100]
     Note:

     Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     Could you do it in-place with O(1) extra space?

     题意：转换数组
     solution：3遍翻转
     */
    public void rotate(int[] nums, int k) {
        k = k % (nums.length);

        helperRotate(nums,0,nums.length-1);
        helperRotate(nums,0,k-1);
        helperRotate(nums,k,nums.length-1);
    }

    private void helperRotate(int[] nums,int start,int end){
        int exchange;
        while(start < end){
            exchange = nums[start];
            nums[start] = nums[end];
            nums[end] = exchange;
            start++;
            end--;
        }
    }
}
