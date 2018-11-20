package com.sun.leetcode.differentkind.tree;


import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2018/11/6
 * Description:
 */
public class MediumLc623 {
    /**
     * 623. Add One Row to Tree
     * <p>
     * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
     * <p>
     * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left
     * subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree
     * should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value
     * v as the new root of the whole original tree, and the original tree is the new root's left
     * <p>
     * 题意：插入一层 数据
     * solution: dfs
     */


    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return new TreeNode(0);

        if (d == 1) {
            TreeNode install = new TreeNode(v);
            install.left = root;
            return install;
        }

        dfs(v, root, 1, d);
        return root;
    }

    private void dfs(int val, TreeNode node, int depth, int n) {
        if (node == null) return;

        if (depth == n - 1) {
            TreeNode swap = node.left;
            node.left = new TreeNode(val);
            node.left.left = swap;

            swap = node.right;
            node.right = new TreeNode(val);
            node.right.right = swap;
        } else {
            dfs(val,node.left,depth+1,n);
            dfs(val,node.right,depth+1,n);
        }
    }
}
