package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    112. Path Sum
 * Description: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals the given sum.
 * Train of thought:
 */
public class LeetCode112 {

    /**
     112. Path Sum
     Easy

     Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

     Note: A leaf is a node with no children.

     Example:

     Given the below binary tree and sum = 22,

     5
     / \
     4   8
     /   / \
     11  13  4
     /  \      \
     7    2      1
     return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */

    // 路径 sum 累减 & 为叶子节点
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right ==null && sum == root.val){
            return true;
        }

        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right ,sum- root.val);
    }
}
