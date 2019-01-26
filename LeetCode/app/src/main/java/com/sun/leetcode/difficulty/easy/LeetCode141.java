package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    141. Linked List Cycle
 * Description: Given a linked list, determine if it has a cycle in it.
 * Follow up:Can you solve it without using extra space?
 * Train of thought:
 */
public class LeetCode141 {
    /**
     141. Linked List Cycle
     Easy

     1249

     97

     Favorite

     Share
     Given a linked list, determine if it has a cycle in it.

     To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.


     */
    // 判断无环：暴力解法： 最后next = null(无重复的)

    // 判断有环： 快慢指针。肯定相遇
    // 两种情况  faster.next == faster.next.next


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode faster = head;
        ListNode slower = head;

        while (faster.next != null && faster.next.next != null) {
            slower = slower.next;
            faster = faster.next.next;

            if (faster.equals(slower)) {
                return true;
            }
        }


        return false;
    }

}
