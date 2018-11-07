package com.sun.leetcode.difficulty.medium;

/**
 * Author: jfson sun
 * Create on:  2018/10/10
 * Question:    50. Pow(x, n)
 * Description: Implement pow(x, n), which calculates x raised to the power n (xn).
 * Train of thought:
 */
public class LeetCode50 {

//    Input: 2.00000, -2
//    Output: 0.25000
//    Explanation: 2-2 = 1/22 = 1/4 = 0.25


    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long n2 = n;

        return helper(x,n2);
    }

    double helper(double x, long n_long){
        if (n_long == 0) {
            return 1;
        }

        if (n_long < 0) {
            x = 1 / x;
            n_long = -n_long;
        }

        return (n_long % 2 == 0) ? helper(x * x, n_long / 2) : x * helper(x * x, n_long / 2);
    }
}
