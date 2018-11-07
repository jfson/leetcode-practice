package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2018/9/29
 * Question:    83. Remove Duplicates from Sorted List
 * Description: Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Train of thought:
 * time :   O(n)
 * space:   O(1)
 */
public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode list = head;

        while (list.next != null ) {
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next; // 重置list 值
            }
        }

        return head; // Head 已经改了
    }
}
