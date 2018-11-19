package com.sun.leetcode.differentkind.dp;

/**
 * Author: jfson sun
 * Create on:  2018/11/19
 * Question:
 * Description:
 * Train of thought:
 */
public class EasyLc303 {
    /**
     * 303. Range Sum Query - Immutable
     Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

     Example:
     Given nums = [-2, 0, 3, -5, 2, -1]

     sumRange(0, 2) -> 1
     sumRange(2, 5) -> -1
     sumRange(0, 5) -> -3
     Note:
     You may assume that the array does not change.
     There are many calls to sumRange function.
     题意：算出区间和
     存储所有区间的和，以便于
     */

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */

    class NumArray {
        private int[] nums;
        private int n = 0;
        private int[] res;

        public NumArray(int[] nums) {
            this.nums = nums;
            n = nums.length;
            if (n == 0) return;
            res = new int[n+1];
            for (int k = 0; k < n; k++) {
                res[k+1] = nums[k] + res[k];
            }
        }

        //solution 2:预处理，结果存储一下
        public int sumRange(int i, int j) {
            return res[j+1] - res[i];
        }

        //solution 1: 暴击解法
        public int sumRange1(int i, int j) {
            int res = 0;
            for (; i <= j; i++) {
                res += nums[i];
            }
            return res;
        }
    }
}
