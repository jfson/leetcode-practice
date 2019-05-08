package com.sun.leetcode.normal;

/**
 * Author: jfson sun
 * Create on:  2019/5/7
 * Question:
 * Description: 快排
 * Train of thought:
 */
public class Sort {
    //[2,5,1,3,5,6]
    /**
     * 视频讲解
     * https://www.bilibili.com/video/av21593465/?p=1
     */


    /**
     * 快速排序（分治）
     * 最坏情况，可以是=相邻的俩个数进行了交换，最差时间复杂度和冒泡排序一样是O(N^2)
     * 平均时间复杂度为O(NlogN)
     */
    private void quickSort(int[] nums, int left, int right) {
        if (left > right) return; // 递归出口

        int temp = nums[left];
        int i = left;
        int j = right;

        while (i != j) {
            //顺序很重要，要从右边开始向左找，找比基准数小的
            while (nums[j] >= temp && i < j) {
                j--;
            }

            while (nums[i] <= temp && i < j) {
                i++;
            }

            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        // 此时 i = j
        nums[left] = nums[i];
        nums[i] = temp;

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }


    /**
     * 冒泡排序
     * 思想：邻居好说话
     * 一次排序后，有一个元素位置是确定的
     */

    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 归并排序
     */
    public void mergeSort() {

    }

    /**
     * 插入排序
     * 思想：分成两部分，一部分已经排好序。扫描到位置插进去即可，
     */
    public void insertSort(int[] nums) {
        // 1,2,4,5, --- 3
        for (int i = 1; i < nums.length-1; i++) {
            int j = i - 1;
            int temp = nums[i];
            for (; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }
}
