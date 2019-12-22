package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2019/12/22
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc215m {
    /**
     在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

     示例 1:

     输入: [3,2,1,5,6,4] 和 k = 2
     输出: 5
     示例 2:

     输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     输出: 4
     说明:

     你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。\

     solution:快排
     */
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if (nums == null || nums.length < k) {
                return 0;
            }
            return find(nums, 0, nums.length - 1, k);
        }

        //逆排序
        private int find(int[] nums, int left, int right, int k) {
            int start = left;
            int end = right;
            int key = nums[start];

            while (start < end) {
                while (start < end && nums[end] <= key) {
                    end--;
                }
                nums[start] = nums[end];
                while (start < end && nums[start] >= key) {
                    start++;
                }
                nums[end] = nums[start];
            }
            nums[start] = key;

            if (start == k - 1) {
                return key;
            }
            //比key大的个数少于k-1个，去后半部分找
            if (start < k - 1) {
                return find(nums, start + 1, right, k );
            }
            return find(nums, left, start - 1, k);
        }
    }
}
