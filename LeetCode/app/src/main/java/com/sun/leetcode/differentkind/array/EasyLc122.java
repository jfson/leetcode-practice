package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/10/31
 * Question:    122. Best Time to Buy and Sell Stock II
 * Description:
 * Train of thought:
 */
public class EasyLc122 {
    /**
     Say you have an array for which the ith element is the price of a given stock on day i.

     Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

     Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

     Input: [7,1,5,3,6,4]
     Output: 7
     Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

     Input: [7,6,4,3,1]
     Output: 0
     Explanation: In this case, no transaction is done, i.e. max profit = 0.

     题意： 买进卖出，获利最多

     solution ： 只要后一个比前一个大，就进行一次买进卖出。。累加差值
     */
    public int maxProfit(int[] prices) {
        int ret = 0;

        if (prices == null || prices.length == 0) return 0;

        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1]){
                ret += prices[i+1] - prices[i];
            }
        }

        return ret;
    }


}
