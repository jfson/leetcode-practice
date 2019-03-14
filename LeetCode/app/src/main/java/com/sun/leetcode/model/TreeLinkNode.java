package com.sun.leetcode.model;

/**
 * Author: jfson sun
 * Create on:  2019/3/15
 * Question:
 * Description:
 * Train of thought:
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode() {}

    public TreeLinkNode(int _val,TreeLinkNode _left,TreeLinkNode _right,TreeLinkNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
