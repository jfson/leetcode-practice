package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2018/12/23
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc75 {
    /**
     75. Sort Colors
     DescriptionHintsSubmissionsDiscussSolution
     Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

     Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

     Note: You are not suppose to use the library's sort function for this problem.

     Example:

     Input: [2,0,2,1,1,0]
     Output: [0,0,1,1,2,2]
     Follow up:

     A rather straight forward solution is a two-pass algorithm using counting sort.
     First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     Could you come up with a one-pass algorithm using only constant space?

     题意：red, white or blue 用0，1，2代表
     solution: while循环，进行swap
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length ==0) return;

        int left = 0;
        int right = nums.length-1;
        int index = 0;

        while (index<=right){
            if (nums[index] == 0){
                swap(nums,index++,left++);
            }else if (nums[index] == 1){
                index++;
            }else {
                swap(nums,index,right--);
            }
        }

    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =  temp;
    }

}
