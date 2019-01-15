package com.sun.leetcode.differentkind.tree;


import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2018/11/6
 * Description:
 */
public class MediumLc226 {
    /**
     * 226. Invert Binary Tree
     * <p>
     * Invert a binary tree.
     * <p>
     * Trivia:
     * This problem was inspired by this original tweet by Max Howell:
     * <p>
     * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
     * <p>
     Input:

              4
            /   \
            2     7
           / \   / \
          1   3 6   9
     Output:

              4
            /   \
           7     2
         / \   / \
        9   6 3   1
     * 题意： 翻转二叉树
     */

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;
    }

}
