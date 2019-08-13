package com.sun.leetcode.differentkind.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/8/13
 * Question:
 * Description:
 * Train of thought:
 */
public class MediumLc90 {
    /**
     90. Subsets II

     Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

     Note: The solution set must not contain duplicate subsets.

     Example:

     Input: [1,2,2]
     Output:
     [
     [2],
     [1],
     [1,2,2],
     [2,2],
     [1,2],
     []
     ]

     题意：打印数组，要求不能重复
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int begin = 0;

        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]) {
                begin = 0;
            }

            int size = result.size();
            for(int j = begin;j < size;j++){
                List<Integer> cur = new ArrayList<Integer>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }

            begin = size;
        }

        return result;
    }
}
