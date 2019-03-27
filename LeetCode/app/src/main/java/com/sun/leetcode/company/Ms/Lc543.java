package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/3/27
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc543 {
    /**
     543. Diameter of Binary Tree
     Easy

     Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

     Example:
     Given a binary tree
     1
     / \
     2   3
     / \
     4   5
     Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

     Note: The length of path between two nodes is represented by the number of edges between them.
     题意：找到TreeNode 的最大直径
     solution：二叉树的直径：二叉树中从一个结点到另一个节点最长的路径，叫做二叉树的直径
     采用分治和递归的思想：根节点为root的二叉树的直径 = Max(左子树直径，右子树直径，左子树的最大深度（不包括根节点）+右子树的最大深度（不包括根节点）+1)
     */
    int ret = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return ret;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);
        ret = Math.max(ret,l+r);
        return Math.max(l,r) +1;
    }
}
