package com.sun.leetcode.difficulty.easy;


/**
 * Author: jfson sun
 * Create on:  2018/10/3
 * Question:    167. Two Sum II - Input array is sorted
 * Description:
 * Train of thought:
 */
public class LeetCode167 {
    // 升序 两头使用夹逼
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        if (numbers == null || numbers.length <= 1) return result;

        int start = 0;
        int end = numbers.length - 1;


        while (start <= end) {
            if (numbers[start] + numbers[end] == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else {//(numbers[start] + numbers[end] < target)
                start++;
            }
        }

        return result;
    }
}
