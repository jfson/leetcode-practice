package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2019/3/17
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc237 {
    /**
     237. Delete Node in a Linked List
     Easy

     Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

     Given linked list -- head = [4,5,1,9], which looks like following:

     Example 1:

     Input: head = [4,5,1,9], node = 5
     Output: [4,1,9]
     Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
     Example 2:

     Input: head = [4,5,1,9], node = 1
     Output: [4,5,9]
     Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
     题意：实现一个删除链表结点的方法
     solution ：关键逻辑判断node.next 是否为null;
     */
    public void deleteNode(ListNode node) {
        if(node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
