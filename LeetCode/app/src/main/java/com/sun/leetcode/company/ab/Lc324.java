package com.sun.leetcode.company.ab;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/12/9
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc324 {
    /**
     * 324. Wiggle Sort II
     * DescriptionHintsSubmissionsDiscussSolution
     * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1, 5, 1, 1, 6, 4]
     * Output: One possible answer is [1, 4, 1, 5, 1, 6].
     * Example 2:
     * <p>
     * Input: nums = [1, 3, 2, 2, 3, 1]
     * Output: One possible answer is [2, 3, 1, 3, 1, 2].
     * Note:
     * You may assume all input has valid answer.
     * <p>
     * Follow Up:
     * Can you do it in O(n) time and/or in-place with O(1) extra space?
     * <p>
     * 题意：排序一个数组
     * solution:  排序，调整的方法是找到数组的中间的数，从中间分成两部分，然后从前半段的末尾取一个，在从后半的末尾去一个，
     * 这样保证了第一个数小于第二个数，接着从前半段取倒数第二个，从后半段取倒数第二个，这保证了第二个数大于第三个数，且第三个数小于第四个数，
     * 以此类推直至都取完。
     *
     */

    public void wiggleSort(int[] nums) {
        //当前时间复杂度O(nlogn) 空间复杂度O(n)
        if (nums == null || nums.length <= 1) return;

        int[] temp = nums.clone();
        Arrays.sort(temp);
        int n = nums.length;
        int left = (n - 1) / 2;
        int right = n - 1;

        int index = 0;

        while (left >= 0 && right >= (n - 1) / 2) {
            nums[index++] = temp[left--];
            if(index < n){nums[index++] = temp[right--];}
        }

        if (left>=0){
            nums[index] = temp[left];
        }

    }

}
