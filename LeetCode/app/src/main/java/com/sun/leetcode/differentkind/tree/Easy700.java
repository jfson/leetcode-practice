package com.sun.leetcode.differentkind.tree;


import com.sun.leetcode.model.TreeNode;

/**
 * Author: sunzhen
 * Create on:  2018/11/5
 * Description:
 */
public class Easy700 {
    /**
     * 700. Search in a Binary Search Tree
     * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that
     * the node's value equals the given value. Return the subtree rooted with that node.
     * If such node doesn't exist, you should return NULL.
     * <p>
     * 题意：n叉树 搜索一个以val 为跟节点的子树，不存在返回NULL
     * solution: 递归

     二叉查找树（英语：Binary Search Tree），也称为二叉搜索树、有序二叉树（ordered binary tree）或排序二叉树（sorted binary tree），是指一棵空树或者具有下列性质的二叉树：
     若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
     若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     任意节点的左、右子树也分别为二叉查找树；
     没有键值相等的节点。
     */

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) {
            return root;
        } else {
            return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }
}
