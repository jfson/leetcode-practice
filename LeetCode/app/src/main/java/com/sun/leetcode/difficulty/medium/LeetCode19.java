package com.sun.leetcode.difficulty.medium;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/6
 * Question:    19. Remove Nth Node From End of List
 * Description:
 * Train of thought: 快慢双指针
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode fast = node,slow = node;

        for (int i = 0; i < n; i++) { // q先走n步
            fast = fast.next;
        }

        while (fast.next != null){ // 一起走到最后
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = fast.next.next;

        return node.next;
    }
}
