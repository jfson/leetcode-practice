package com.sun.leetcode.differentkind.array;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: jfsonsun
 * Create on:  2018/11/1
 * Description:
 */
public class EasyLc697 {
    /**
     * 697. Degree of an Array
     * <p>
     * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
     * <p>
     * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
     * <p>
     * Example 1:
     * Input: [1, 2, 2, 3, 1]
     * Output: 2
     * Explanation:
     * The input array has a degree of 2 because both elements 1 and 2 appear twice.
     * Of the subarrays that have the same degree:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * The shortest length is 2. So return 2.
     * Example 2:
     * Input: [1,2,2,3,1,4,2]
     * Output: 6
     * Note:
     * <p>
     * nums.length will be between 1 and 50,000.
     * nums[i] will be an integer between 0 and 49,999.
     * <p>
     * 题意： 构成的元素组成的数组（连续的）。。其中的最长的元素的个数一致，返回最短的那个
     * Input: [1, 7, 7, 5, 7, 1]
     * Output: 4
     * 说明：此数组的度数为3，因为7显示为任何数字的最大值。你可以制作的度数为3的最短子阵是[7,7,5,7]。该子阵列的长度为4，因此我们返回4。
     * <p>
     * 分析： [1, 7, 7, 5, 7, 1]   left = 1,right = 4  ;return right-left +1
     */

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> left = new HashMap(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i); // 存第一次的索引
            right.put(x, i);// 每次都覆盖，所以是最后一次的索引
            count.put(x, count.getOrDefault(x, 0) + 1);  // 计次
        }

        int ret = nums.length;
        int degree = Collections.max(count.values()); // max

        for (int x : count.keySet()) {
            if (count.get(x) == degree){
                ret = Math.min(ret,right.get(x) - left.get(x) +1);
            }
        }

        return ret;
    }
}
