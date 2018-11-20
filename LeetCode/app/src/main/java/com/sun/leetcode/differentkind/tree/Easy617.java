package com.sun.leetcode.differentkind.tree;


import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2018/11/5
 * Description:
 */
public class Easy617 {
    /**
     617. Merge Two Binary Trees
     Given two binary trees and imagine that when you put one of them to cover the other,
     some nodes of the two trees are overlapped while the others are not.

     You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
     then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

     题意： 合并两个Tree.. 位置重贴的则叠加
     solution 1: 迭代：时间复杂度 O(n)
     */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        TreeNode ret = new TreeNode(-1);

        if (t1 == null){
            ret.val = t2.val;
            ret.left = mergeTrees(null,t2.left);
            ret.right = mergeTrees(null,t2.right);

        }else if(t2 == null){
            ret.val = t1.val;
            ret.left = mergeTrees(t1.left,null);
            ret.right = mergeTrees(t1.right,null);
        }else {// t1 != null && t2!= null
            ret.val = t1.val + t2.val;
            ret.left = mergeTrees(t1.left,t2.left);
            ret.right = mergeTrees(t1.right,t2.right);
        }

        return ret;
    }
}
