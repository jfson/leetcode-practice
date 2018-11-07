package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/9/28
 * Question: 66. Plus One
 * Description: Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * Train of thought:
 */
public class LeetCode66 {
//    Input: [1,2,3]
//    Output: [1,2,4]
//    Explanation: The array represents the integer 123.
        // int + 1.。看末位是否为9

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{1};

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        //[0,0,0]
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        return ret;
    }

}
