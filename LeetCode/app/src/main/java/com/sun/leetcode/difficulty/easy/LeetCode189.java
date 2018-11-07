package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/10/3
 * Question:    189. Rotate Array
 * Description: Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Train of thought:
 */
public class LeetCode189 {
//    Input: [1,2,3,4,5,6,7] and k = 3
//    Output: [5,6,7,1,2,3,4]
//    Explanation:
//    rotate 1 steps to the right: [7,1,2,3,4,5,6]
//    rotate 2 steps to the right: [6,7,1,2,3,4,5]
//    rotate 3 steps to the right: [5,6,7,1,2,3,4]


    // 利用三次翻转即可
    // 1.全部翻转
    // 2. 0 ~ k-1 翻转
    // 3. k ~ nums - 1 翻转
    public void rotate(int[] nums, int k) {
        k = k % nums.length;    //    if (k > nums.length) return;

        rotateNums(nums, 0, nums.length - 1);
        rotateNums(nums, 0, k - 1);
        rotateNums(nums, k, nums.length - 1);
    }

    public void rotateNums(int[] nums, int start, int end) {
        int exchange;
        while (start < end) {
            exchange = nums[start];
            nums[start] = nums[end];
            nums[end] = exchange;
            start++;
            end--;
        }
    }
}
