package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/1
 * Question:    110. Balanced Binary Tree
 * Description: Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Train of thought:
 */
public class LeetCode110 {
    /**
     110. Balanced Binary Tree
     Easy

     Given a binary tree, determine if it is height-balanced.

     For this problem, a height-balanced binary tree is defined as:

     a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

     Example 1:

     Given the following tree [3,9,20,null,null,15,7]:

     3
     / \
     9  20
     /  \
     15   7
     Return true.

     Example 2:

     Given the following tree [1,2,2,3,3,null,null,4,4]:

     1
     / \
     2   2
     / \
     3   3
     / \
     4   4

     题意：判断是不是高度平衡二叉树
     solution: 根据deep,左右树层级不超过1
     */
    public boolean isBalanced(TreeNode root) {
        if (checkBalanced(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int checkBalanced(TreeNode tree) {
        if (tree == null) return 0;

        int left = checkBalanced(tree.left);
        if (left == -1) return -1;

        int right = checkBalanced(tree.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            // 返回其最大深度
            return Math.max(left, right) + 1;
        }
    }
}
