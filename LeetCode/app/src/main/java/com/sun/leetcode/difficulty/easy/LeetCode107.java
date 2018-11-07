package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/9/30
 * Question:    Binary Tree Level Order Traversal II
 * Description: Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * Train of thought:
 */
public class LeetCode107 {

    //    [3,9,20,null,null,15,7],
//    return [  [15,7],[9,20], [3] ]

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList lists = new LinkedList<List<Integer>>();
        addToList(root,lists,0);

        return lists;
    }

    public void addToList(TreeNode root, LinkedList<List<Integer>> result, int level) {
        if (root == null) return;

        // not null
        if (result.size() < level + 1){
            result.addFirst(new ArrayList<Integer>());
        }

        result.get(result.size() -1 -level).add(root.val); //

        addToList(root.left,result,level+1);
        addToList(root.right,result,level+1);
    }

}
