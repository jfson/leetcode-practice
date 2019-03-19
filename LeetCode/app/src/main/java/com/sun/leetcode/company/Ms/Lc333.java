package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/3/19
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc333 {
    /**
     333. Largest BST Subtree
     Medium

     Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

     Note:
     A subtree must include all of its descendants.

     Example:

     Input: [10,5,15,1,8,null,7]

     10
     / \
     5  15
     / \   \
     1   8   7

     Output: 3
     Explanation: The Largest BST Subtree in this case is the highlighted one.
     The return value is the subtree's size, which is 3.
     Follow up:
     Can you figure out ways to solve it with O(n) time complexity?
     题意：找到最大BST结点数
     solution：先判断是否是BST,是则找到该Node的数量。不是则去找左子树或者右子树的最大Node数量
     */

    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;

        if(helper(root,Long.MIN_VALUE,Long.MAX_VALUE)){
            return nodeCount(root);
        }

        int left = largestBSTSubtree(root.left);
        int right = largestBSTSubtree(root.right);
        return Math.max(left,right);

    }

    private int nodeCount(TreeNode root){
        if(root == null) return 0;

        return nodeCount(root.left) + nodeCount(root.right) +1;
    }

    private boolean helper(TreeNode root, long left, long right){
        if(root == null) return true;

        if(root.val <= left || root.val >= right){
            return false;
        }

        return helper(root.left,left,root.val)&&helper(root.right,root.val,right);
    }
}
