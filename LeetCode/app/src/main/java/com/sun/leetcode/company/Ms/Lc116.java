package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeLinkNode;

/**
 * Author: jfson sun
 * Create on:  2019/3/15
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc116 {
    /**
     116. Populating Next Right Pointers in Each Node
     Medium

     You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

     struct Node {
     int val;
     Node *left;
     Node *right;
     Node *next;
     }
     Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

     Initially, all next pointers are set to NULL.



     Example:



     Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

     Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

     Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.

     题意：在每个节点中填充下一个右指针，left->right->next.left
     solution:递归
     */

    public TreeLinkNode connect(TreeLinkNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeLinkNode root){
        if(root == null) return;

        TreeLinkNode node = root.next;
        if(node != null){
            if(node.right != null){
                root.right.next = node.left;
                root.left.next = root.right;
            }
        }else{
            if(root.right != null){
                root.right.next = null;
                root.left.next = root.right;
            }
        }

        connect(root.left);
        connect(root.right);
    }
}
