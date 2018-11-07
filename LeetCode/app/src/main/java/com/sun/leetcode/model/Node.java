package com.sun.leetcode.model;

import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/11/6
 * Question:
 * Description:
 * Train of thought:
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
