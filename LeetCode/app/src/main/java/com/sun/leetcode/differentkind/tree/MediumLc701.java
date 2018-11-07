package com.sun.leetcode.differentkind.tree;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2018/11/6
 * Question:
 * Description:
 * Train of thought:
 */
public class MediumLc701 {
    /**
     701. Insert into a Binary Search Tree

     Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node
     of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

     Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.


     题意：BST ,插入一个数据
     solution:
     */

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root,val,new TreeNode(val));
    }

    public TreeNode helper(TreeNode root, int val,TreeNode node){
        if (root == null) return node;

        if (root.val > val){
            root.left = helper(root.left,val,node);
        }else {
            root.right = helper(root.right,val,node);
        }

        return root;
    }

}
