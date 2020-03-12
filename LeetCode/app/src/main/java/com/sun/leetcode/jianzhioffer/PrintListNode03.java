package com.sun.leetcode.jianzhioffer;

import com.sun.leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: jfson sun
 * Create on:  2020/3/12
 * Question:
 * Description:
 * Train of thought:
 */
public class PrintListNode03 {
    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList();
        if(listNode == null){
            return ret;
        }

        while(listNode != null){
            ret.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(ret);

        return ret;
    }
}
