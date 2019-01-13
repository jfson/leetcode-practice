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

    /**
     88. Merge Sorted Array
     Easy
     Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

     Note:

     The number of elements initialized in nums1 and nums2 are m and n respectively.
     You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     Example:

     Input:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3

     Output: [1,2,2,3,5,6]

     题意：合并两个数组
     */

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

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;

        int current = m + n - 1;
        int n1 = m-1;
        int n2 = n-1;

        while(n1 >= 0 && n2 >= 0){
            if(nums1[n1] >= nums2[n2]){
                nums1[current] = nums1[n1];
                n1--;
            }else{
                nums1[current] = nums2[n2];
                n2--;
            }
            current--;
        }



        while(n2>=0){
            nums1[current--] = nums2[n2--];

        }

        while(n1>=0){
            nums1[current--] = nums1[n1--];
        }

    }

}
