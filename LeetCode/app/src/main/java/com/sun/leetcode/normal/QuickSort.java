package com.sun.leetcode.normal;

/**
 * Author: jfson sun
 * Create on:  2019/5/7
 * Question:
 * Description: 快排
 * Train of thought:
 */
public class QuickSort {
    //[2,5,1,3,5,6]


    /**
     最坏情况，可以是=相邻的俩个数进行了交换，最差时间复杂度和冒泡排序一样是O(N^2)
     平均时间复杂度为O(NlogN)
     */

    private void sort(int[] nums,int left,int right){
        if (left > right) return;

        int temp = nums[left];
        int i = left;
        int j = right;

        while (i != j){
            //顺序很重要，要从右边开始向左找，找比基准数小的
            while (nums[j] >= temp && i < j){
                j--;
            }

            while (nums[i] <= temp && i < j){
                i++;
            }

            if (i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

//        此时 i = j
        nums[left] = nums[i];
        nums[i] = temp;

        sort(nums,left,i-1);
        sort(nums,i+1,right);
    }
}
