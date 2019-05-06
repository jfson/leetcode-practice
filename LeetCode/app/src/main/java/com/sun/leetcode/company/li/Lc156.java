package com.sun.leetcode.company.li;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/5/6
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc156 {
    /**
     * 156. Binary Tree Upside Down
     * Medium
     * <p>
     * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3,4,5]
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * <p>
     * Output: return the root of the binary tree [4,5,2,#,#,3,1]
     * <p>
     * 4
     * / \
     * 5   2
     * / \
     * 3   1
     * Clarification:
     * <p>
     * Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.
     * <p>
     * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
     * <p>
     * Here's an example:
     * <p>
     * 1
     * / \
     * 2   3
     * /
     * 4
     * \
     * 5
     * The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
     * 题意：翻转二叉树
     * solution ：递归
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right; // node2.left
        root.left.right = root;// node2.right
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
