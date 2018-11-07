package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/9
 * Question:  46. Permutations
 * Description:
 * Train of thought:
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        helper(res,nums,new ArrayList<Integer> ());
        return res;
    }

    void helper(List<List<Integer>> res, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res, nums, list);
            list.remove(list.size() - 1);
        }
    }
}
