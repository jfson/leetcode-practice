package com.sun.leetcode.company.Microsoft;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2018/12/18
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc206 {
    /**
     206. Reverse Linked List
     DescriptionHintsSubmissionsDiscussSolution
     Reverse a singly linked list.

     Example:

     Input: 1->2->3->4->5->NULL
     Output: 5->4->3->2->1->NULL

     Follow up:

     A linked list can be reversed either iteratively or recursively. Could you implement both?


     题意：翻转链表
     Follow up:用递归和遍历
     solution：1指向null..2指向1，3指向2
     */

    /**
     iteratively
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    /**
     recursively
     出口：head == null
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(head,null);
    }

    public ListNode reverse(ListNode head,ListNode newHead){
        if (newHead == null)
            return newHead;

        ListNode next = head.next;
        head.next = newHead;
       return reverse(next,head);
    }

    public ListNode reverseList3(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null){return newHead;}

        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }
}
