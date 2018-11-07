package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/6
 * Question:    18. 4Sum
 * Description:
 * Train of thought:  固定2个num
 */
public class LeetCode18 {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> hashSet = new HashSet<>(); // check repeat
        List<List<Integer>> ret = new ArrayList<>();

        if (nums == null || nums.length < 4) return ret;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {

                int start = j + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];

                    if (sum == target) {
                        List<Integer> addList = new ArrayList<>();
                        addList.add(nums[i]);
                        addList.add(nums[j]);
                        addList.add(nums[start]);
                        addList.add(nums[end]);

                        if (!hashSet.contains(addList)) {
                            ret.add(addList);
                            hashSet.add(addList);
                        }

                        start++;
                        end--;
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }

                }
            }
        }


        return ret;
    }
}
