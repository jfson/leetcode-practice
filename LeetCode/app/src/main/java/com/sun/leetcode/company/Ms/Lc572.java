package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/3/19
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc572 {
    /**
     572. Subtree of Another Tree
     Easy

     Given two non-empty binary trees s and t, check whether tree t has exactly the same
     structure and node values with a subtree of s. A subtree of s is a tree consists of
     a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
     Example 1:
     Given tree s:

     3
     / \
     4   5
     / \
     1   2
     Given tree t:
     4
     / \
     1   2
     Return true, because t has the same structure and node values with a subtree of s.
     Example 2:
     Given tree s:

     3
     / \
     4   5
     / \
     1   2
     /
     0
     Given tree t:
     4
     / \
     1   2
     Return false.
     题意：判断s中是否包含 t
     solution ： 子方法判断是否t包含s相同,主方法判断当前Node是否包含跟 左右子树是否包含
     */

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
