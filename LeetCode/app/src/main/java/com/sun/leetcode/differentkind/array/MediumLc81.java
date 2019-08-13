package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2019/8/13
 * Question:
 * Description:
 * Train of thought:
 */
public class MediumLc81 {
    /**
     81. Search in Rotated Sorted Array II

     Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

     You are given a target value to search. If found in the array return true, otherwise return false.

     Example 1:

     Input: nums = [2,5,6,0,0,1,2], target = 0
     Output: true
     Example 2:

     Input: nums = [2,5,6,0,0,1,2], target = 3
     Output: false
     Follow up:

     This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
     Would this affect the run-time complexity? How and why?

     题意：在一个排序后的数组中，查找一个数
     解决：二分查找。
     */
    /**
     *  数组中存在重复元素，并且可以旋转。这时候查找某个数
     */
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }

        //[2,5,6,0,0,1,2]
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid =start + (end - start) / 2;

            if(nums[mid] == target){
                return true;
            }
            //[2,3,3,3,3,4,5,6,1,2]
            if(nums[mid] == nums[end]){
                end--;
            }else if(nums[mid] < nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                if(target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
