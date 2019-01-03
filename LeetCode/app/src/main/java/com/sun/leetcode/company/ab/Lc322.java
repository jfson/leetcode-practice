package com.sun.leetcode.company.ab;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/12/24
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc322 {
    /**
     322. Coin Change
     DescriptionHintsSubmissionsDiscussSolution
     You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

     Example 1:

     Input: coins = [1, 2, 5], amount = 11
     Output: 3
     Explanation: 11 = 5 + 5 + 1
     Example 2:

     Input: coins = [2], amount = 3
     Output: -1
     Note:
     You may assume that you have an infinite number of each kind of coin.

     题意：找零钱。计算最少硬币组成一个数。。没有则返回-1
     solution： DP
     F(3) = min{F(3-1),F(3-2),F(3-3)} + 1
     F(i) = min{F(i - )
     */


    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);

        dp[0] = 0;

        for (int i = 1;i <= amount;i++){
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 :dp[amount];
    }


}
