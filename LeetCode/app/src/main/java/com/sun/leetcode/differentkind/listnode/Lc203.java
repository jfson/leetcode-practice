package com.sun.leetcode.differentkind.listnode;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2019/1/17
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc203 {
    /**
     203. Remove Linked List Elements
     Easy

     Remove all elements from a linked list of integers that have value val.

     Example:

     Input:  1->2->6->3->4->5->6, val = 6
     Output: 1->2->3->4->5
     题意：移除元素
     solution: 新建一个头，值为-1；判断node.next == null 作为循环。因为需要将上一个节点指向下下一个节点
     */

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(-1);
        node.next = head;

        ListNode curr = node;

        while(curr.next != null){
            if (curr.next.val == val){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }

            if (curr == null) break;
        }

        return node.next;
    }
}
