package com.sun.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    118. Pascal's Triangle
 * Description: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Train of thought:
 */
public class LeetCode118 {
//    Input: 5
//    Output:
//            [
//            [1],
//            [1,1],
//            [1,2,1],
//            [1,3,3,1],
//            [1,4,6,4,1]
//            ]

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();

        if (numRows == 0) return ret;


        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(); //first
            list.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> getList = ret.get(i - 1);
                int num = getList.get(j - 1) + getList.get(j);
                list.add(num);
            }

            if (i!=0){
                list.add(1); //end
            }
            ret.add(list);
        }

        return ret;
    }


}
