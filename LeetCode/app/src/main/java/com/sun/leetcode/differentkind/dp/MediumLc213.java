package com.sun.leetcode.differentkind.dp;

/**
 * Author: jfson sun
 * Create on:  2018/11/20
 * Description:
 */
public class MediumLc213 {
    /**
     * 213. House Robber II
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * Example 1:
     * <p>
     * Input: [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
     * because they are adjacent houses.
     * Example 2:
     * <p>
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * <p>
     * 题意： 还是抢房子。相邻屋子不可强。。且房子是环形的。第一个和最后一个相连。求能抢的最大的钱
     * solution: 抢了第一个，最后一个就不能抢了，抢了最后一个，第一个就不能抢了（分两次计算，去首&去尾-->取其max）
     */

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        // start = 0
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length-1; i++) {
            res[i] = Math.max(nums[i]+res[i-2],res[i-1]);
        }
        int ret1 = res[nums.length-2];

        // start = 1
        res[0] = 0;
        res[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(nums[i]+res[i-2],res[i-1]);
        }

        int ret2 = res[nums.length-1];
        return Math.max(ret1,ret2);
    }

}
