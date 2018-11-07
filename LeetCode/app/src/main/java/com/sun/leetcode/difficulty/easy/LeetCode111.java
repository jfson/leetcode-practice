package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    111. Minimum Depth of Binary Tree
 * Description: Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * Train of thought:
 */
public class LeetCode111 {
//    递归解法急速判断左右两边子树哪个depth最小，要注意如果有个节点只有一边孩子时，不能返回0，要返回另外一半边的depth。

    public int minDepth(TreeNode root) {
        return deep(root);
    }

    public int deep(TreeNode root) {
        if (root == null) return 0;

        int left = deep(root.left);
        int right = deep(root.right);

        if (left == 0 || right == 0) {
            return left >= right ? left + 1 : right + 1;
        }

        return Math.min(left, right) + 1;
    }
}
