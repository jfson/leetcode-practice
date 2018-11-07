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
