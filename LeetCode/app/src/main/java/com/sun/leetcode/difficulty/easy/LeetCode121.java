package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    121. Best Time to Buy and Sell Stock
 * Description: Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Train of thought:
 */
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxNum = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int num = prices[j] - prices[i];
                if (num > 0 && num > maxNum) {
                    maxNum = num;
                }
            }
        }

        return maxNum;
    }
}
