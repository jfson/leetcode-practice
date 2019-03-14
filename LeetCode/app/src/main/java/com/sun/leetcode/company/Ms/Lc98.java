package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/3/14
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc98 {

    /**
     98. Validate Binary Search Tree
     Medium

     Share
     Given a binary tree, determine if it is a valid binary search tree (BST).

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.
     Example 1:

     Input:
     2
     / \
     1   3
     Output: true
     Example 2:

     5
     / \
     1   4
     / \
     3   6
     Output: false
     Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
     is 5 but its right child's value is 4.
     题意：判断一个树为BST
     solution:递归
     */

    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root,long min,long max){
        if(root == null) return true;

        if(root.val >= max || root.val <= min) return false;

        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}
