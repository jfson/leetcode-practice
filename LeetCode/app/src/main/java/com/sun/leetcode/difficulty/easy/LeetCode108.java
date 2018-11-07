package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/1
 * Question:    108. Convert Sorted Array to Binary Search Tree
 * Description:Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Train of thought:
 */
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode ret = new TreeNode(nums[mid]);
        ret.left = buildTree(nums, start, mid - 1);
        ret.right = buildTree(nums, mid + 1, end);
        return ret;
    }
}
