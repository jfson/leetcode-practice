package com.sun.leetcode.differentkind.tree;

import com.sun.leetcode.model.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2018/11/5
 * Description:
 */
public class Easy590 {
    /**
     590. N-ary Tree Postorder Traversal
     Given an n-ary tree, return the postorder traversal of its nodes' values.
     Return its postorder traversal as: [5,6,3,2,4,1].

     题意： n叉树，事后遍历。不用递归，用遍历
     solution: 用 stack 存储child 节点(因为后序遍历，所以遍历)。  用while 轮训child 节点值并存储..
     最后记得翻转list
     example:
            1
        /   \   \
        3    2   4
       /\
      5 6

     return [5,6,3,2,4,1]

     */

    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;

        Stack<Node> stack = new Stack();
        stack.push(root);
        
        while (!stack.isEmpty()){
            root = stack.pop();
            ret.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                stack.push(root.children.get(i));
            }
        }

        Collections.reverse(ret);

        return ret;
    }
}
