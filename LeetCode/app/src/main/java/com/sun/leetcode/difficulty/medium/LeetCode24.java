package com.sun.leetcode.difficulty.medium;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2018/10/6
 * Question:    24. Swap Nodes in Pairs
 * Description:
 * Train of thought:
 */
public class LeetCode24 {


    /**
     * 1 - 2 -3 -4 -5
     * <p>
     * 0(l1) -> 1(l2) -> 2 -> 3 ->  4 -> 5
     * <p>
     * // l1.next = l2.next;
     * 0(l1) -> 2(l2) -> 2 -> 3 ->  4 -> 5
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            swap(current);
            current = current.next.next;
        }

        return dummy.next;
    }

    // 只交换next
    void swap(ListNode pre) {
        ListNode dummy = pre.next;
        pre.next = dummy.next;
        dummy.next = dummy.next.next;
        pre.next.next = dummy;
    }
}
