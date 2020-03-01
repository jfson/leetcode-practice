package com.sun.leetcode.company.bytedance;

import com.sun.leetcode.model.ListNode;
import com.sun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: jfson sun
 * Create on:  2020/2/29
 * Question:
 * Description: 中序先序后序遍历一棵树
 * Train of thought:
 */
public class TreeSort {
    /**
     *       1
     *    2    3
     *  4  5   6 7
     */
    //先序遍历
    public static void sortDLRTree(TreeNode root){
        if(root == null){
            return;
        }

        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(root);

        while (queue.isEmpty()){
            TreeNode curr = queue.poll();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            queue.add(left);
            queue.add(right);

            ret.add(curr.val);
        }

    }


    public void getTree(){

    }
}
