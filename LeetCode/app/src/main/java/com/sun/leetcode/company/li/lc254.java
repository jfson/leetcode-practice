package com.sun.leetcode.company.li;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/5/3
 * Question:
 * Description:
 * Train of thought:
 */
public class lc254 {
    /**
     254. Factor Combinations
     Medium

     Numbers can be regarded as product of its factors. For example,

     8 = 2 x 2 x 2;
     = 2 x 4.
     Write a function that takes an integer n and return all possible combinations of its factors.

     Note:

     You may assume that n is always positive.
     Factors should be greater than 1 and less than n.
     Example 1:

     Input: 1
     Output: []
     Example 2:

     Input: 37
     Output:[]
     Example 3:

     Input: 12
     Output:
     [
     [2, 6],
     [2, 2, 3],
     [3, 4]
     ]
     Example 4:

     Input: 32
     Output:
     [
     [2, 16],
     [2, 2, 8],
     [2, 2, 2, 4],
     [2, 2, 2, 2, 2],
     [2, 4, 4],
     [4, 8]
     ]

     题意：找出乘积因子
     solution ：回溯
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res,list,n,2);
        return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> list,int n,int factor){
        if (n <= 1){
            if (list.size() > 1){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }


        for (int i = factor; i <= n; i++) {
            if (n % i == 0){
                list.add(i);
                helper(res,list,n/i,i);
                list.remove(list.size()-1);
            }
        }
    }
}
