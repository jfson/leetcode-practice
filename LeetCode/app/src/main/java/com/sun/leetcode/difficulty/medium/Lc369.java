package com.sun.leetcode.difficulty.medium;

import com.sun.leetcode.model.ListNode;

/**
 * Author: jfson sun
 * Create on:  2019/4/2
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc369 {
    /**
     369. Plus One Linked List
     Medium

     Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.

     Example :

     Input: [1,2,3]
     Output: [1,2,4]
     题意：链表表示一个数，对该数进行+1操作
     solution：翻转过来+1比较简单，计算完成后再翻转回去
     */
    public ListNode plusOne(ListNode head) {
        // 翻转过来+1比较简单，计算完成后再翻转回去
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode x = dummy;
        int carry = 1;
        while (carry > 0 || x.next != null) {
            if (x.next != null) {
                x = x.next;
                carry += x.val;
                x.val = carry % 10;
                carry /= 10;
            }
            else {
                x.next = new ListNode(carry);
                x = x.next;
                carry = 0;
            }
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }
}
