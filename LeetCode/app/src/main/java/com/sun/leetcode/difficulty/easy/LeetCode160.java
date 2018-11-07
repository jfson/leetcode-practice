package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    160. Intersection of Two Linked Lists
 * Description:
 * Train of thought:
 */
public class LeetCode160 {

    // 扫描两遍必定在交集点重逢
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

}
