package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/3/17
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc669 {
    /**
     669. Trim a Binary Search Tree
     Easy

     Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

     Example 1:
     Input:
            1
          / \
         0   2
     L = 1
     R = 2
     Output:
            1
            \
             2
     Example 2:
     Input:
          3
         / \
        0   4
         \
         2
       /
      1

     L = 1
     R = 3

     Output:
     3
     /
     2
     /
     1

     题意：修剪二叉搜索树；这题其实就是“二叉搜索树中删除一个结点”的变形
     solution：递归。
     */


    public TreeNode trimBST(TreeNode root, int L, int R) {
        // 递归
        if(root == null) return root;

        if(root.val < L)
            return trimBST(root.right,L,R);

        if(root.val > R)
            return trimBST(root.left,L,R);

        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);

        return root;
    }
}
