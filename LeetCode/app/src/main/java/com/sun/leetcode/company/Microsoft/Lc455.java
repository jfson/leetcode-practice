package com.sun.leetcode.company.Microsoft;

import com.sun.leetcode.model.ListNode;

import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2018/12/19
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc455 {
    /**
     445. Add Two Numbers II
     DescriptionHintsSubmissionsDiscussSolution
     You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Follow up:
     What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

     Example:

     Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 8 -> 0 -> 7

     题意：两个链表相加。不能改变序列、不能用翻转。 7240+564 = 7807
     solution:借助Stack
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode node = new ListNode(0);
        while (!s1.empty() || !s2.empty()){
            if (!s1.empty()){
                sum+=s1.pop();
            }

            if (!s2.empty()){
                sum+=s2.pop();
            }
            node.val = sum%10;
            ListNode head = new ListNode(sum/10);
            head.next = node;
            node = head;
            sum/=10;
        }


        return node.val == 0 ? node.next:node;
    }
}
