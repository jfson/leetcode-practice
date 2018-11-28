package com.sun.leetcode.differentkind.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/11/28
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMedium78 {
    /**
     * 78. Subsets
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * Example:
     * <p>
     * Input: nums = [1,2,3]
     * Output:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     * <p>
     * 题意： 返回所有可能的子集
     * solution: 典型的回溯
     */


    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        backTracking(lists,new ArrayList<Integer>(),nums,0);
        return lists;
    }

    public void backTracking(List<List<Integer>> list,List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));

        for (int i = start; i <  nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; //skip

            tempList.add(nums[i]);
            backTracking(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
