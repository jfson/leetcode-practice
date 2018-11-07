package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/9/28
 * Question:
 * Description: Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * Train of thought: 二分查找
 */
public class LeetCode69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;


        long min = 0;
        long max = x / 2 + 1;
        long mid; // int * int 防止溢出用long

        while (min <= max) {
            mid = (long)(min + max) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }


        return (int)max;

    }
}
