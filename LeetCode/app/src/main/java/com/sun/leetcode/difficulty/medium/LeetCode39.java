package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/7
 * Question:
 * Description:
 * Train of thought:
 */
public class LeetCode39 {
    /**
     39. Combination Sum
     Medium
     Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

     The same repeated number may be chosen from candidates unlimited number of times.

     Note:

     All numbers (including target) will be positive integers.
     The solution set must not contain duplicate combinations.
     Example 1:

     Input: candidates = [2,3,6,7], target = 7,
     A solution set is:
     [
     [7],
     [2,2,3]
     ]
     Example 2:

     Input: candidates = [2,3,5], target = 8,
     A solution set is:
     [
     [2,2,2,2],
     [2,3,3],
     [3,5]
     ]

     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,new ArrayList<Integer>(),candidates,target,0);
        return res;
    }

    public void helper(List<List<Integer>> list, List<Integer> addList,int[] candidates, int targetItemNum,int start) {
        if (targetItemNum < 0){
            return;
        }else if (targetItemNum == 0) {
            list.add(new ArrayList<>(addList));
        }else{
            for (int i = start; i < candidates.length; i++) {
                addList.add(candidates[i]);
                helper(list,addList,candidates,targetItemNum - candidates[i],i);
                addList.remove(addList.size() - 1);
            }
        }
    }
}
