package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/9/29
 * Question:    70. Climbing Stairs
 * Description:    You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * Train of thought:
 */
public class LeetCode70 {
    /**
     70. Climbing Stairs
     Easy

     You are climbing a stair case. It takes n steps to reach to the top.

     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

     Note: Given n will be a positive integer.

     Example 1:

     Input: 2
     Output: 2
     Explanation: There are two ways to climb to the top.
     1. 1 step + 1 step
     2. 2 steps
     Example 2:

     Input: 3
     Output: 3
     Explanation: There are three ways to climb to the top.
     1. 1 step + 1 step + 1 step
     2. 1 step + 2 steps
     3. 2 steps + 1 step
     */
    // 1.   1 step
    // 2.   1 step + 1 steps /2
    // 3.   2 + 1
    // 递归
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    // 递归优化-动态规划法
    public int climbStairsOhter(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int lastStepOne = 1;
        int lastStep = 2;
        int num;
        for (int i = 2; i < n; i++) {
            num = lastStepOne;
            lastStepOne = lastStep;
            lastStep += num;
        }

        return lastStep;
    }
}
