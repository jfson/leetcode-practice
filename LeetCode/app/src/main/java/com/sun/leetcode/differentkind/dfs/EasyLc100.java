package com.sun.leetcode.differentkind.dfs;

import com.sun.leetcode.model.TreeNode;

import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2018/11/21
 * Description:
 */
public class EasyLc100 {
    /**
     100.Same Tree

     Given two binary trees, write a function to check if they are the same or not.

     Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

     Example 1:

     Input:     1         1
     / \       / \
     2   3     2   3

     [1,2,3],   [1,2,3]

     Output: true
     Example 2:

     Input:     1         1
     /           \
     2             2

     [1,2],     [1,null,2]

     Output: false
     Example 3:

     Input:     1         1
     / \       / \
     2   1     1   2

     [1,2,1],   [1,1,2]

     Output: false
     * 题意：判断两个二叉树是否相等
     * solution 1: 递归 (暴力解法)
     * solution 2: stack
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);
        while (!stackP.empty() && !stackQ.empty()) {
            TreeNode popP = stackP.pop();
            TreeNode popQ = stackQ.pop();

            if (popP != null && popQ != null && popP.val != popQ.val) return false;

            if (popP == null && popQ != null) return false;

            if (popP != null && popQ == null) return false;

            if (popP != null) {
                stackP.push(popP.left);
                stackP.push(popP.right);
            }

            if (popQ != null) {
                stackQ.push(popQ.left);
                stackQ.push(popQ.right);
            }

        }

        return true;
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }
}
