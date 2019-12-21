package com.sun.leetcode.company.Ms;

import android.util.Log;

/**
 * Author: jfson sun
 * Create on:  2019/12/21
 * Question:
 * Description:
 * Train of thought:
 */
public class FindNum {
    public static void print() {
        int[] res = {8,7,6,5,3,4,5};
        int x = findMinNum(res);
        Log.e("jfson:",String.valueOf(x));
    }

    /**
     * 8765368
     * case: null ""
     * case:是否可能只存在递增的部分或者只存在递减的部分，
     * case:是否存在重复
     */
    public static int findMinNum(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 0){
            return nums[0];
        }
        if(nums.length == 1){
            return Math.min(nums[0],nums[1]);
        }

        int left = 0;
        int right = nums.length -1;
        int mid;
        while(left < right){
            mid = (right - left)/2;

            if(nums[mid] < nums[mid-1] && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(nums[mid] < nums[mid-1]){
                left = mid+1;
            }else if(nums[mid] > nums[mid + 1]){
                right = mid -1;
            }
        }
        return -1;
    }
}
