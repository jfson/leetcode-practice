package com.sun.leetcode.differentkind.tree;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/1/16
 * Question:
 * Description:
 * Train of thought:
 */
public class Easy104 {
    /**
     104. Maximum Depth of Binary Tree
     Easy

     Given a binary tree, find its maximum depth.

     The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

     Note: A leaf is a node with no children.

     Example:

     Given binary tree [3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     return its depth = 3.

     */

    public int maxDepth(TreeNode root) {
        int ret = 0;

        if(root == null){
            return 0;
        }else{
            ret = Math.max(ret,maxDepth(root.left));
            ret = Math.max(ret,maxDepth(root.right));
        }

        return ret+1;
    }
}
