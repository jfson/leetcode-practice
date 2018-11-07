package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/5
 * Question:    15. 3Sum
 * Description:
 * Train of thought: 排序后夹逼
 */
public class LeetCode15 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);


        if (nums.length < 3) return result;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;

            findNums(nums, i, i + 1, nums.length - 1);
        }

        return result;
    }

    // 夹逼
     void findNums(int[] nums, int currentNum, int start, int end) {
        while (start < end) {
            if (nums[currentNum] + nums[start] + nums[end] == 0) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[currentNum]);
                list.add(nums[start]);
                list.add(nums[end]);
                result.add(list);

                // go on
                while (start < end && nums[start] == nums[start+1]) start++;
                while (start < end && nums[end] == nums[end-1]) end--;

                start++;
                end--;

            } else if (nums[currentNum] + nums[start] + nums[end] > 0) {
                end--;
            } else { // < 0
                start++;
            }
        }
    }
}
