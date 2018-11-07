package com.sun.leetcode.differentkind.array;

/**
 * Author: jfsonsun
 * Create on:  2018/11/1
 * Description:
 */
public class EasyLc167 {
    /**
     * 167. Two Sum II - Input array is sorted
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     * <p>
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     * <p>
     * Note:
     * <p>
     * Your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * Example:
     * <p>
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     * <p>
     * 题意： 有序数组中找到和为target的索引,返回index +1
     * solution: while 进行逼近，直到return
     */

    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        if (numbers == null || numbers.length == 0) {
            return ret;
        }

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                ret[0] = i + 1;
                ret[1] = j + 1;
                return ret;
            } else if (sum < target) {
                ++i;
            } else {
                --j;
            }
        }

        return ret;
    }
}
