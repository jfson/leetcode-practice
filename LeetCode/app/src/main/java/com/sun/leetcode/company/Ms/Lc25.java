package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2019/4/1
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc25 {
    /**
     25. Reverse Nodes in k-Group
     Hard

     Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

     k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

     Example:

     Given this linked list: 1->2->3->4->5

     For k = 2, you should return: 2->1->4->3->5

     For k = 3, you should return: 3->2->1->4->5

     Note:

     Only constant extra memory is allowed.
     You may not alter the values in the list's nodes, only nodes itself may be changed.
     题意：每K项，进行链表的翻转
     solution：递归翻转
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        // 1-2-3  / 3-2-1
        // 4-5 .

        if(head == null || head.next == null) return head;

        int count = 0;
        ListNode cur = head;
        while(cur != null && count != k){
            count++;
            cur = cur.next;
        }

        // 1-2-3
        if(count == k){
            cur = reverseKGroup(cur,k);// 4-5
            while(count > 0){
                ListNode swap = head.next;
                head.next = cur;
                cur = head;
                head = swap;
                count--;
            }
            head = cur;
        }
        return head;
    }
}
