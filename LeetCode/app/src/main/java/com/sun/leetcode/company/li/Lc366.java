package com.sun.leetcode.company.li;

import com.sun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/5/3
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc366 {
    /**
     366. Find Leaves of Binary Tree
     Medium

     Share
     Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

     Example:

     Input: [1,2,3,4,5]

      1
     / \
     2   3
     / \
     4   5

     Output: [[4,5,3],[2],[1]]


     Explanation:

     1. Removing the leaves [4,5,3] would result in this tree:

     1
     /
     2


     2. Now removing the leaf [2] would result in this tree:

     1

     3. Now removing the leaf [1] would result in the empty tree:

     []


     题意：一个二叉树，返回其每层的叶节点
     solution： dfs
     */

    public List<List<Integer>> findLeaves(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public int helper(TreeNode root,List<List<Integer>> res){
        if (root == null){
            return 0;
        }

        int depth = Math.max(helper(root.left,res),helper(root.right,res));
        while (res.size() <= depth){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }

        res.get(depth).add(root.val);
        return depth+1;
    }
}
