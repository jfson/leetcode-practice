package com.sun.leetcode.company.snap;

import com.sun.leetcode.model.RandomListNode;

import java.util.HashMap;

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
     deep copy: HashMap 预存。根据key...找出next,random

     题意：
     */


    public RandomListNode copyRandomList(RandomListNode head) {

        return null;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null){
            map.put(node,new RandomListNode(node.label));
            node = node.next;
        }
        node = head;

        while (node!=null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }


}
