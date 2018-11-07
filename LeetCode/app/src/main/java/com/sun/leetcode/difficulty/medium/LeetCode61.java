package com.sun.leetcode.difficulty.medium;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/12
 * Question: 61. Rotate List
 * Description: Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * Train of thought:
 */
public class LeetCode61 {
    // 快慢指针
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;

        ListNode res = new ListNode(0);
        res.next = head;

        ListNode fast = res;
        ListNode slower = res;

        int i;
        for ( i = 0; fast.next !=null; i++) {
            fast = fast.next;
        }

        for (int j = i - k%i; j >0; j--) {
            slower = slower.next;
        }

//        res.next = slower.next;
//        fast.next = head;
//        slower.next = null;

        fast.next = res.next;
        res.next = slower.next;
        slower.next = null;

        return res.next;
    }
}
