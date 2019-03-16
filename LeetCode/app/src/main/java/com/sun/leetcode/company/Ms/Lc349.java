package com.sun.leetcode.company.Ms;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Author: jfson sun
 * Create on:  2019/3/16
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc349 {
    /**
     349. Intersection of Two Arrays
     Easy

     Given two arrays, write a function to compute their intersection.

     Example 1:

     Input: nums1 = [1,2,2,1], nums2 = [2,2]
     Output: [2]
     Example 2:

     Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     Output: [9,4]
     Note:

     Each element in the result must be unique.
     The result can be in any order.

     题意：求交集
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums1.length;i++){
            set.add(nums1[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i< nums2.length;i++){
            if(set.contains(nums2[i]) && !list.contains(nums2[i])) list.add(nums2[i]);
        }

        int[] ret = new int[list.size()];
        int j =0;
        for (int i = 0; i < list.size(); i++) {
            ret[j++] = list.get(i);
        }

        return ret;
    }
}
