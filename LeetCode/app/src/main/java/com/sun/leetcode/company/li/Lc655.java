package com.sun.leetcode.company.li;

import com.sun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/5/7
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc655 {
    /**
     655. Print Binary Tree
     Medium

     Print a binary tree in an m*n 2D string array following these rules:

     The row number m should be equal to the height of the given binary tree.
     The column number n should always be an odd number.
     The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
     Each unused space should contain an empty string "".
     Print the subtrees following the same rules.
     Example 1:
     Input:
     1
     /
     2
     Output:
     [["", "1", ""],
     ["2", "", ""]]
     Example 2:
     Input:
     1
     / \
     2   3
     \
     4
     Output:
     [["", "", "", "1", "", "", ""],
     ["", "2", "", "", "", "3", ""],
     ["", "", "4", "", "", "", ""]]
     Example 3:
     Input:
     1
     / \
     2   5
     /
     3
     /
     4
     Output:

     [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
     ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
     ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
     ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
     Note: The height of binary tree is in the range of [1, 10].

     题意：在一个m*n的二维数组中打印二叉树，输出数组
     行号m应该等于给定二叉树的高度。
     列号n应始终为奇数

     solution：首先计算出树的高度h，然后建立h行、(2的h次方-1)列的字符串数组，进行先序遍历，
     设立l和r表示当前填充的子树对应的字符串数组的左右下标区域，h表示当前的层数，每次将root->val的值存储入ans[h][mid]中，
     其中mid=(l+r)/2，然后继续遍历左子树和右子树，将区间分为0～mid-1和mid+1～r，高度h加1，直至遍历完成后返回ans数组～

     ps别人的分析:：既然要打印二叉树，显然是需要遍历一遍二叉树才行的。
     常见遍历二叉树的方法有：前序遍历，中序遍历，后续遍历以及层序遍历。
     按照此题的特点应该选择层序遍历是比较符合要求的。接下来，我们要求出树的高度h，这样就能知道最终返回结果的行数了。
     并且也知道每行的列数col=(1 << h)-1。然后的任务就是在每一列合适的位置插入二叉树的结点值了。观测发现，
     若输入的二叉树是一棵满二叉树，第一行的首元素在 col / 2 处，第二行的首元素在 col / 4处，第三行的首元素在 col / 8 处.....；第一行只有一个结点，第二行有两个结点，
     结点之间的间隔为 （2^（height - 1）-1）,第三行之间的间隔为（2^（height - 2）-1）,第四行之间的间隔为（2^（height - 3）-1）......，
     最后一行的间隔为1。这样我们就解决了满二叉树打印的问题了；那么对于不是满二叉树的一般二叉树来说怎么办呢？ 好办！假设它是满二叉树就可以了，
     对于null结点，我们假设它有两个null的左右孩子，这样它不就成了一棵满二叉树了吗。
     下面是AC代码：

     关键信息：数组长度为2的n次方-1；n为层高
     */


    public List<List<String>> printTree(TreeNode root) {
        int rows = root == null ? 1 : getLevel(root);
        int columns =(int) (Math.pow(2,rows) -1);

        List<List<String>> res = new LinkedList<>();
        List<String> row = new ArrayList<>();
        //填充默认
        for (int i = 0; i < columns; i++) {
            row.add("");
        }

        for (int i = 0; i < rows; i++) {
            res.add(new ArrayList<>(row));
        }

        helper(root,res,0,rows,0,columns-1);


        return res;
    }

    public void helper(TreeNode root,List<List<String>> res,int row,int totalRows,int i,int j){
        if(row == totalRows || root == null) return;
        res.get(row).set(i+j/2,Integer.toString(root.val));
        helper(root.left, res, row+1, totalRows, i, (i+j)/2 - 1);
        helper(root.right, res, row+1, totalRows, (i+j)/2+1, j);
    }


    public int getLevel(TreeNode root){
        if (root == null)return 0;
        return Math.max(getLevel(root.left),getLevel(root.right)) +1;
    }
}
