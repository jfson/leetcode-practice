package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/3/24
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc215 {
    /**
     215. Kth Largest Element in an Array
     Medium

     Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

     Example 1:

     Input: [3,2,1,5,6,4] and k = 2
     Output: 5
     Example 2:

     Input: [3,2,3,1,2,4,5,5,6] and k = 4
     Output: 4
     Note:
     You may assume k is always valid, 1 ≤ k ≤ array's length.
     题意：找到第k个大的数
     solution：快排后，返回k-1索引的数
     */

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[k-1];
    }

    private void quickSort(int[] nums,int l,int r){
        if(l > r) return;

        int i = l,j = r,curr = nums[l];
        while(i != j){
            // start r
            while(nums[j] <= curr && i < j){
                j--;
            }

            while(nums[i] >= curr && i < j){
                i++;
            }

            if(i < j){
                int swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
            }
        }

        // i == j
        nums[l] = nums[i];
        nums[i] = curr;

        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }
}
