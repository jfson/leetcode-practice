package com.sun.leetcode.differentkind.tree;


import com.sun.leetcode.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: sunzhen
 * Create on:  2018/11/5
 * Description:
 */
public class Easy589 {
    /**
     589. N-ary Tree Preorder Traversal

     Given an n-ary tree, return the preorder traversal of its nodes' values.
     Note:

     Recursive solution is trivial, could you do it iteratively?

     题意：前序遍历n叉数，不用递归，用遍历
     solution: 用 stack 存储child 节点(因为前序遍历，所以遍历用倒序h)。  用while 轮训child 节点值并存储..
     // stack 压栈add() == push()
     */

    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()){
            root = stack.pop();
            ret.add(root.val);
            for (int i = root.children.size()-1; i >=0; i--) {
                stack.add(root.children.get(i));
            }
        }

        return ret;
    }
}
