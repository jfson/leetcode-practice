package com.sun.leetcode.differentkind.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: jfson sun
 * Create on:  2018/10/31
 * Question:    217. Contains Duplicate
 * Description:
 * Train of thought:
 */
public class EasyLc217 {

    /**
     Given an array of integers, find if the array contains any duplicates.

     Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

     Example 1:

     Input: [1,2,3,1]
     Output: true
     Example 2:

     Input: [1,2,3,4]
     Output: false
     Example 3:

     Input: [1,1,1,3,3,4,3,2,4,2]
     Output: true

     题意： 有重复元素则为true

     solution 1:  用个hashset 排重
     solution 2: 先排序，前后有相等则true
     */

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }

        return false;
    }
}
