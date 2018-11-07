package com.sun.leetcode.difficulty.easy;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2018/9/24
 * Question: 21. Merge Two Sorted Lists
 * Description: Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Train of thought: 依次比较排序 加入空列表的next中，最后两个list 都为null... 输出 空列表的next
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode firstNullListNode = new ListNode(0);
        ListNode lastNode = firstNullListNode;

        while (l1 != null && l2 != null) { // all null
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null){ // l1 null
            lastNode.next = l1;
        }else { // l2 null
            lastNode.next = l2;
        }

        return firstNullListNode.next;
    }

}


