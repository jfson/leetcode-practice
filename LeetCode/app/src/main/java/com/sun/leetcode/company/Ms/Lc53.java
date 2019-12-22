package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/12/22
 * Question:
 * Description:
 * Train of thought:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 进阶:

 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Lc53 {
    /**
     *  贪心：该算法通用且简单：遍历数组并在每个步骤中更新：
        当前元素位置的最大和
        迄今为止的最大和
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for(int s : nums){
            if(sum > 0){
                sum += s;
            }else{
                sum = s;
            }
            res = Math.max(sum,res);
        }
        return res;
    }
}
