package com.sun.leetcode.company.Microsoft;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Author: jfson sun
 * Create on:  2019/1/1
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc706 {
    /**
     706. Design HashMap
     DescriptionHintsSubmissionsDiscussSolution
     Design a HashMap without using any built-in hash table libraries.

     To be specific, your design should include these functions:

     put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
     get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
     remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

     Example:

     MyHashMap hashMap = new MyHashMap();
     hashMap.put(1, 1);
     hashMap.put(2, 2);
     hashMap.get(1);            // returns 1
     hashMap.get(3);            // returns -1 (not found)
     hashMap.put(2, 1);          // update the existing value
     hashMap.get(2);            // returns 1
     hashMap.remove(2);          // remove the mapping for 2
     hashMap.get(2);            // returns -1 (not found)

     Note:

     All keys and values will be in the range of [0, 1000000].
     The number of operations will be in the range of [1, 10000].
     Please do not use the built-in HashMap library.
     */

    /** Initialize your data structure here. */

    class MyHashMap {
        ListNode[] nodes;


        /** Initialize your data structure here. */
        public MyHashMap() {
            nodes = new ListNode[1000];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int i = idx(key);
            if (nodes[i] == null){
                nodes[i] = new ListNode(-1,-1);
            }

            ListNode prev = find(nodes[i],key);
            if (prev.next == null){
                prev.next = new ListNode(key,value);
            }else {
                prev.next.val = value;
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int i = idx(key);
            if (nodes[i] == null){
                return -1;
            }
            ListNode node = find(nodes[i],key);

            return node.next == null ? -1:node.next.val;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int i = idx(key);
            if (nodes[i] == null) return;

            ListNode node = find(nodes[i],key);
            if (node == null) return;

            node.next = node.next.next;
        }

        @SuppressLint("NewApi")
        int idx(int key){
            return Integer.hashCode(key) % nodes.length;
        }

        // find 前置ListNode
        ListNode find(ListNode bucket,int key){
            ListNode node = bucket,prev = null;
            while (node != null && node.key != key){
                prev = node;
                node = node.next;
            }
            return prev;
        }
    }

    class ListNode{
        int key,val;
        ListNode next;

        ListNode(int key,int value){
            this.key = key;
            this.val = value;
        }
    }



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
