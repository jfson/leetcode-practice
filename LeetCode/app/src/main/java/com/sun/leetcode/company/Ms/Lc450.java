package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/3/13
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc450 {
    /**
     450. Delete Node in a BST
     Medium

     Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

     Basically, the deletion can be divided into two stages:

     Search for a node to remove.
     If the node is found, delete the node.
     Note: Time complexity should be O(height of tree).

     Example:
     root = [5,3,6,2,4,null,7]
     key = 3

         5
        / \
       3   6
      / \   \
     2   4   7

     Given key to delete is 3. So we find the node with value 3 and delete it.
     One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

         5
        / \
       4   6
      /     \
     2       7

     Another valid answer is [5,2,6,null,4,null,7].
          5
         / \
        2   6
        \   \
        4   7

     题意： 在一个BST删除一个节点。
     BST:任意节点中，left比root节点小，right节点比root节点大
     solution：递归解；分四种情况
     a.结点为null时，返回null
     b.key 小于改结点时，递归删除左边
     c.key 大于改结点时，递归删除右边
     d.key 等于结点时，找到root.right中最小结点，在root.val替换该结点后并删除
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // root.right!= null && root.left =null
            // 右边最小的挪上来，并删除该元素
            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right,root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }
}
