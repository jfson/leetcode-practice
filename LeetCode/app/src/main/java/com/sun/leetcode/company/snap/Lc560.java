package com.sun.leetcode.company.snap;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.HashMap;

/**
 * Author: jfson sun
 * Create on:  2018/12/15
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc560 {
    /**
     * 560. Subarray Sum Equals K
     * DescriptionHintsSubmissionsDiscussSolution
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
     * <p>
     * Example 1:
     * Input:nums = [1,1,1], k = 2
     * Output: 2--->前两个1和后两个1，sum = 2
     * Note:
     * The length of the array is in range [1, 20,000].
     * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     * 题意：有多少连续的子数组。它的和为k
     * solution:prefixSum..预存sum做为key
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (Integer res : nums) {
            sum += res;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return count;
    }

}
