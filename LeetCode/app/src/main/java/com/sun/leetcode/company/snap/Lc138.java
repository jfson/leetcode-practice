package com.sun.leetcode.company.snap;

import java.util.HashMap;

/**
 * Author: jfson sun
 * Create on:  2018/12/16
 * Question:
 * Description:
 * Train of thought:
 */


class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class Lc138 {

    /**
     138. Copy List with Random Pointer
     DescriptionHintsSubmissionsDiscussSolution
     A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

     Return a deep copy of the list.

     1->2->3->4
     1 - new 1 ->new2
     2 - new 2
     3 - new 3
     4 - new 4
     deep copy:

     题意：
     */


    public RandomListNode copyRandomList(RandomListNode head) {

        return null;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        if (cur != null){
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;

        while (cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }


}
