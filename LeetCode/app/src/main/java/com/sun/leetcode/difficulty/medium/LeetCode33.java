package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/7
 * Question:    33. Search in Rotated Sorted Array
 * Description:
 * Train of thought:
 */
public class LeetCode33 {

    /**
     * 题解
     * Binary Search
     * <p>
     * // 1
     * 7,0,1,    2    ,4,5,6
     * left     mid    right
     * <p>
     * right = mid + 1
     * left = mid -1
     * <p>
     * // 2
     * 3,4,5,   6     ,7,1,2
     * left     mid    right
     * right = mid - 1
     * left = mid -1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            }else {
                if (target <nums[mid] && target >=nums[left]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }

        return -1;
    }
}
