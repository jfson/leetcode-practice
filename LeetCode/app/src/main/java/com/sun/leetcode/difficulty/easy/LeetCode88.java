package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/9/29
 * Question:    88. Merge Sorted Array
 * Description: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Train of thought:
 */
public class LeetCode88 {
//    Input:
//    nums1 = [1,2,3,0,0,0], m = 3
//    nums2 = [2,5,6],       n = 3
//    Output: [1,2,2,3,5,6]
    //nums1 的空间足够

    // 这里注意的是，如果比较后没有产生赋值，那么索引也不会--
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;// current Position

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
    }

}
