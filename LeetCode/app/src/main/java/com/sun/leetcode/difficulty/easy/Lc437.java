package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/5/12
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc437 {

    /**
     437. Path Sum III
     Easy

     You are given a binary tree in which each node contains an integer value.

     Find the number of paths that sum to a given value.

     The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

     The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

     Example:

     root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

     10
     /  \
     5   -3
     / \    \
     3   2   11
     / \   \
     3  -2   1

     Return 3. The paths that sum to 8 are:

     1.  5 -> 3
     2.  5 -> 2 -> 1
     3. -3 -> 11
     题意： 二叉树中有多少种组合的和为num
     solution: 递归
     */
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }

        return helper(root,sum) +helper(root.left,sum) + helper(root.right,sum);
    }

    public int helper(TreeNode root,int sum){
        if(root == null){
            return 0;
        }

        int curr = 0;
        if(root.val == sum){
            curr += 1;
        }
        curr += helper(root.left,sum-root.val);
        curr += helper(root.right,sum-root.val);
        return curr;
    }
}
