package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/12/19
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc103 {
    /**
     103. Binary Tree Zigzag Level Order Traversal
     DescriptionHintsSubmissionsDiscussSolution
     Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

     For example:
     Given binary tree [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     return its zigzag level order traversal as:
     [
     [3],
     [20,9],
     [15,7]
     ]
     题意：”之字形” 顺序输出结点

     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(res,root,0);
        return res;
    }

    public void traversal(List<List<Integer>> res,TreeNode curr,int level){
        if (curr == null) return;

        if (res.size() <= level){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }

        List<Integer> list = res.get(level);
        if (level%2 == 0) {
            list.add(curr.val); // left to right
        }else { // right to left
            list.add(0,curr.val);
        }

        traversal(res,curr.left,level+1);
        traversal(res,curr.right,level+1);
    }

}
