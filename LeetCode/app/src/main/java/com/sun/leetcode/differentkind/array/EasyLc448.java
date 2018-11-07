package com.sun.leetcode.differentkind.array;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/31
 * Question:   448. Find All Numbers Disappeared in an Array
 * Description:
 * Train of thought:
 */
public class EasyLc448 {

    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * <p>
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     * <p>
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     * <p>
     * Input:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * Output:
     * [5,6]
     * <p>
     * 题意：找出 1-n 中消失的数
     * <p>
     * solution：
     * [4,3,2,7,8,2,3,1]   1-8
     * <p>
     * step 1:
     * index ---> 3,2,1,6,7,1,2,0
     * <p>
     * //for
     * [4,3,2,-7,8,2,3,1]
     * [4,3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,-3,1]
     * [-4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [-4,-3,-2,-7,8,2,-3,-1]
     * <p>
     * <p>
     * <p>
     * 套用那个经典的给元素值赋正负来表达额外信息的套路:正负号标记法  nums[nums[i] -1] = -nums[nums[i]-1]
     * 数组长度为n，数组中元素的取值范围为[1, n]�，数组index范围为[0, n - 1]。也就是说如果数组元素没有重复，那么对于每个元素k，都对应一个index k-1.
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) return list;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }

}
