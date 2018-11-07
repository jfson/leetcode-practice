package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/8
 * Question:   40. Combination Sum II
 * Description:
 * Train of thought:
 */
public class LeetCode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfsHelper(list, new ArrayList<Integer>(), candidates, target, 0);

        return list;
    }

    void dfsHelper(List<List<Integer>> res, List<Integer> list, int[] candidates, int taget, int start) {
        if (taget < 0){
            return;
        }else if (taget == 0){
            res.add(new ArrayList<>(list));
            return;
        }else {
            int last = -1;
            for (int i = start; i < candidates.length; i++) {
                if (last == candidates[i]) continue;
                if (taget < candidates[i]) return;
                last = candidates[i];

                list.add(candidates[i]);
                dfsHelper(res, list, candidates, taget - candidates[i], i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}
