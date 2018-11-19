package com.sun.leetcode.differentkind.dp;

/**
 * Author: jfson sun
 * Create on:  2018/11/19
 * Question:
 * Description:
 * Train of thought:
 */
public class EasyLc198 {
    /**
     * 198. House Robber
     * You are a professional robber planning to rob houses along a street. Each house has a
     * certain amount of money stashed, the only constraint stopping you from robbing each of
     * them is that adjacent houses have security system connected and it will automatically contact
     * the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * Example 2:
     * <p>
     * Input: [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     * <p>
     * 题意： 抢劫一条街，相邻的回触发报警。如何才能抢到最大的金额并且不触发报警
     * solution: 一个房子有两种情况： 抢或者不抢
     * 抢： 则是 n-2 的最大值 + 当前值
     * 不抢： 则是 n-1 的最大值
     */

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int dp1 = 0, dp2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int dp = Math.max(dp2 + nums[i], dp1);
            dp2 = dp1;
            dp1 = dp;
        }


        return dp1;
    }

}
