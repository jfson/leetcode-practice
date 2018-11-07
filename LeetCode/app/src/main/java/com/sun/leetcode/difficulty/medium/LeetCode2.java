package com.sun.leetcode.difficulty.medium;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/3
 * Question:    2. Add Two Numbers
 * Description: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Train of thought:
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int current = 0;
        ListNode head = new ListNode(0);

        ListNode ln1 = l1, ln2 = l2, ln3 = head;

        while (ln1 != null || ln2 != null) {
            if (ln1 != null) {
                current += ln1.val;
                ln1 = ln1.next;
            }

            if (ln2 != null) {
                current += ln2.val;
                ln2 = ln2.next;
            }

            ln3.next = new ListNode(current % 10);
            ln3 = ln3.next;
            current /= 10;

        }

        if (current == 1) // 最高位
            ln3.next = new ListNode(1);

        return head.next;
    }
}
