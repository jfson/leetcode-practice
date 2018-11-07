package com.sun.leetcode.differentkind.tree;

import com.sun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/11/6
 * Question:
 * Description:
 * Train of thought:
 */
public class Medium113 {

    /**
     * 113. Path Sum II
     Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

     Note: A leaf is a node with no children.

     Example:

     Given the below binary tree and sum = 22,

     题意：求所有到最底层的sum 路径
     * dfs 回溯
     */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> current = new LinkedList<>();

        helper(root,sum,ret,current);
        return ret;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> current) {
        if (root == null) return;

        current.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList<>(current));
            current.remove(current.size() - 1);
            return;
        } else {
            helper(root.left, sum - root.val, result, current);
            helper(root.right, sum - root.val, result, current);
            current.remove(current.size() - 1);
        }
    }
}
