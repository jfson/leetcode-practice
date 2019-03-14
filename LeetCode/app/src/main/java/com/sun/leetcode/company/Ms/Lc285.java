package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.TreeNode;

/**
 * Author: jfson sun
 * Create on:  2019/3/14
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc285 {
    /**
     285. Inorder Successor in BST
     Medium

     624

     47

     Favorite

     Share
     Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

     The successor of a node p is the node with the smallest key greater than p.val.



     Example 1:
            2
          /  \
         1    3

     Input: root = [2,1,3], p = 1
     Output: 2
     Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
     Example 2:

                5
              /  \
             3    6
           /  \
          2    4
         /
        1

     Input: root = [5,3,6,2,4,null,null,1], p = 6
     Output: null
     Explanation: There is no in-order successor of the current node, so the answer is null.
     题意：我们要找一个大于该点的最小值
     sloution:题目给定根节点和目标节点。目标节点如果有右节点的情况比较好处理，我们只要返回它的右节点的最左边的节点就行了（右节点自己没有左节点时则是右节点本身）。
     如果目标节点没有右节点，说明比目标节点稍大的节点应该在上面，因为我们知道目标节点的左节点肯定是比目标节点要小的。
     那怎么知道目标节点的上面是什么呢？这时就需要从根节点搜索到目标节点了。这里要注意的是，目标节点的父亲不一定比目标节点大，
     因为有可能目标节点的是其父亲的右孩子。所以我们要找的上面，实际上是从目标节点向根节点回溯时，第一个比目标节点大的节点。
     最差的情况下，如果回溯到根节点还是比目标节点要小的话，说明目标节点就是整个数最大的数了，这时候返回空。
     那怎么实现目标节点向根节点回溯，这里用一个栈就行了，在我们寻找目标节点时，把路径上的节点都压入栈中。
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        // 找到，返回其右子树的左结点。
        if(root.val <= p.val){
            return inorderSuccessor(root.right,p);
        }else{ //> 存在返回，不存在返回跟节点
            TreeNode left = inorderSuccessor(root.left,p);
            if(left != null) {
                return left;
            }else{
                return root;
            }
        }
    }
}
