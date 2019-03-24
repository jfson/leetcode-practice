package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/3/24
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc102 {
    /**
     102. Binary Tree Level Order Traversal
     Medium
     binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

     For example:
     Given binary tree [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7]
     ]
     题意：遍历
     solution: DFS 递归
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(ret,root,0);
        return ret;
    }

    private void helper(List<List<Integer>> ret,TreeNode root,int level){
        if(root == null) return;
        if(ret.size() < level+1){
            ret.add(new ArrayList<Integer>());
        }

        ret.get(level).add(root.val);
        helper(ret,root.left,level+1);
        helper(ret,root.right,level+1);
    }
}
