package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2018/9/30
 * Question:    101. Symmetric Tree
 * Description: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Train of thought:
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        return isMirror(left.left,right.right) && isMirror(left.right,right.left) && left.val == right.val;
    }

}
