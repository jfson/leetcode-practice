package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/12/22
 * Question:
 * Description:
 * Train of thought:
 *
 */
public class Lc298 {
    /**
     给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。

     该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。

     这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。

     思路：dfs 递归;出口为：结点null
     */
    public int longestConsecutive(TreeNode root) {
        return helper(root,null,0);
    }

    public int helper(TreeNode root,TreeNode parent,int path){
        if(root == null){
            return path;
        }

        int currMaxPath;
        if(parent != null && root.val == (parent.val + 1)){
            currMaxPath = path+1;
        }else{
            currMaxPath = 1;
        }

        return Math.max(path,Math.max(
                helper(root.left,root,currMaxPath),
                helper(root.right,root,currMaxPath)
        ));
    }
}
