package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2019/3/22
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc173 {
    /**
     173. Binary Search Tree Iterator
     Medium

     Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

     Calling next() will return the next smallest number in the BST.

     Example:

     BSTIterator iterator = new BSTIterator(root);
     iterator.next();    // return 3
     iterator.next();    // return 7
     iterator.hasNext(); // return true
     iterator.next();    // return 9
     iterator.hasNext(); // return true
     iterator.next();    // return 15
     iterator.hasNext(); // return true
     iterator.next();    // return 20
     iterator.hasNext(); // return false
     题意：实现API
     solution: 左序遍历。。首次把所有最left元素压栈。每次取的时候将root结点的右边结点的所有左侧压栈
     */
    Stack<TreeNode> stack;

    public Lc173(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node;
        if(curr.right != null){
            curr = curr.right;
            while(curr != null){
                stack.push(curr);
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    break;
                }
            }
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root){
        TreeNode curr = root;
        while(curr != null){
            stack.push(curr);
            if(curr.left != null){
                curr = curr.left;
            }else{
                break;
            }
        }
    }

}
