package com.sun.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Author: jfson sun
 * Create on:  2018/9/24
 * Description:Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class LeetCode1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int[] ret =  new int[2];

            if(nums == null || nums.length <= 1) return ret;
            map.put(nums[0],0);

            for(int i = 1;i<nums.length;i++){
                int n = target - nums[i];
                if(map.containsKey(n)){
                    ret[0] = map.get(n);
                    ret[1] = i;
                    return ret;
                }else{
                    map.put(nums[i],i);
                }
            }

            return ret;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
//        List<Integer> numsList = Arrays.asList(nums);
//        ArrayList numsList = new ArrayList();
//        numsList.contains(3);
////
////        List ints = Arrays.asList(nums);
////        Integer[] test = {1,2,3,6,89,9};
////        List intsList = Arrays.asList(test);
//
//        int[] nums1 = nums;
//        System.out.println(Arrays.asList(nums));
//
//        HashMap<Integer,Integer> set = new HashMap<>();
//        set.con


//        ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(nums));


//        if (nums == null) {
//            return new int[]{};
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int first = nums[i];
//            int right = target - first;
////            if (Arrays.asList(nums).contains(right)) {
////                return new int[]{i, nums.};
////            }
//        }

        return new int[]{};
    }
}
