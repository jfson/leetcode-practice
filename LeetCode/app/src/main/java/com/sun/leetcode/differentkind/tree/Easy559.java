package com.sun.leetcode.differentkind.tree;


import com.sun.leetcode.model.Node;

/**
 * Author: jfson sun
 * Create on:  2018/11/5
 * Description:
 */
public class Easy559 {
    /**
     * 559. Maximum Depth of N-ary Tree
     * <p>
     * Given a n-ary tree, find its maximum depth.
     * <p>
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * We should return its max depth, which is 3.
     * Note:
     * The depth of the tree is at most 1000.
     * The total number of nodes is at most 5000.
     * 题意：n叉树，返回其深度
     * solution 1: 递归,最后+1
     * solution 2: DFS
     */

    public int maxDepth(Node root) {
        int ret = 0;
        if (root == null) {
            return 0;
        } else {
            for (int i = 0; i < root.children.size(); i++) {
                int current = maxDepth(root.children.get(i));
                ret = Math.max(ret, current);

            }
        }
        return ret + 1;
    }


    int max = 0;
    public int maxDepth2(Node root) {
        int ret = 0;
        if (root == null) {
            return 0;
        }



        return ret + 1;
    }

    void maxDepth(Node node,int depth){
        if (node == null) return;
        max = Math.max(max,depth);
        for (int i = 0; i < node.children.size(); i++) {
            maxDepth(node.children.get(i),depth+1);
        }
    }
}
