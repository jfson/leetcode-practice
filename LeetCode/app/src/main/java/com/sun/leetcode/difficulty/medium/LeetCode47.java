package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/9
 * Question: 47. Permutations II
 * Description:Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Train of thought:
 */
public class LeetCode47 {

    /**
     * Input: [1,1,2]
     * Output:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];

        helper(res,nums,new ArrayList<Integer> (),visited);
        return res;
    }

    void helper(List<List<Integer>> res, int[] nums, List<Integer> list,boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i>0 && nums[i-1] == nums[i] && !visited[i-1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(res, nums, list,visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
