package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2019/1/3
 * Question:
 * Description:
 * Train of thought:
 */
public class FindMedianinLargeIntegerFileofIntegers {
    /*
        Find Median in Large Integer File of Integers
        AirBnB Interview Question 找中位数
        找Integer[]中位数。二分查找.(不能用索引，只能按顺序访问，不能存在内存中)
        思路就是：先找在INT_MIN和INT_MAX的median（0？），然后读large file of integers，找出比这个数小的个数是否有一半，然后调整二分的边界
        Find the median from a large file of integers. You can not access the numbers by index, can only access it sequentially. And the numbers cannot fit in memory.
     */

    public static void main(String[] args) {
        // Solution sol = new FindMedianinLargeIntegerFileofIntegers().new Solution();
        System.out.print("right - left：:" + (Integer.MAX_VALUE - Integer.MIN_VALUE));
        System.out.println();
        findMedian(new int[]{3, -2, 7});
        findMedian(new int[]{-100, 99, 3, 0, 5, 7, 11, 66, -33});
        findMedian(new int[]{4, -100, 99, 3, 0, 5, 7, 11, 66, -33});
    }

    // public class Solution {
    private static long search(int[] nums, int k, long left, long right) {
        if (left >= right) {
            return left;
        }

        long res = left;
        long guess = (left + right)/ 2;
        System.out.print("guess:" + guess);
        System.out.println();
        int count = 0;
        for (int num : nums) {
            if (num <= guess) {
                count++;
                res = Math.max(res, num);
            }
        }

        if (count == k) {
            return res;
        } else if (count < k) {
            return search(nums, k, Math.max(res + 1, guess), right);
        } else {
            return search(nums, k, left, res);
        }
    }

    public static double findMedian(int[] nums) {
        int len = 0;
        for (int num : nums) {
            len++;
        }

        double ret;
        if (len % 2 == 1) {
            ret = (double) search(nums, len / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            ret = (double) (search(nums, len / 2, Integer.MIN_VALUE, Integer.MAX_VALUE) +
                    search(nums, len / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE)) / 2;
        }

        System.out.print(ret);
        System.out.println();
        return ret;
    }
}
