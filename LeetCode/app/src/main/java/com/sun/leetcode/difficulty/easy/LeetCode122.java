package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    122. Best Time to Buy and Sell Stock II
 * Description: Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * Train of thought:
 */
public class LeetCode122 {
    // 不限制买进 并卖出
    public int maxProfit(int[] prices) {

        int ret = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                ret += prices[i + 1] - prices[i];
            }
        }

        return ret;
    }
}
