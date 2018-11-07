package com.sun.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:   119. Pascal's Triangle II
 * Description: Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * Train of thought:
 */
public class LeetCode119 {
//    Input: 3
//    Output: [1,3,3,1]

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ret = new ArrayList<>();

//        if (rowIndex == 0) return ret;

        int deepNum = rowIndex + 1;

        for (int i = 0; i < deepNum; i++) {
            List<Integer> list = new ArrayList<>(); //first
            list.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> getList = ret.get(i - 1);
                int num = getList.get(j - 1) + getList.get(j);
                list.add(num);
            }

            if (i != 0) {
                list.add(1); //end
            }
            ret.add(list);
        }

        return ret.get(rowIndex);
    }
}
