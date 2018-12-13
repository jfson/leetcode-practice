package com.sun.leetcode.company.snap;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Author: jfson sun
 * Create on:  2018/12/13
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc460 {
    /**
     * 460. LFU Cache
     * DescriptionHintsSubmissionsDiscussSolution
     * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
     * <p>
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
     * <p>
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     * <p>
     * Example:
     * <p>
     * LFUCache cache = new LFUCache( 2 /* capacity );
     * <p>
     * cache.put(1, 1);
     * cache.put(2, 2);
     * cache.get(1);       // returns 1
     * cache.put(3, 3);    // evicts key 2
     * cache.get(2);       // returns -1 (not found)
     * cache.get(3);       // returns 3.
     * cache.put(4, 4);    // evicts key 1.
     * cache.get(1);       // returns -1 (not found)
     * cache.get(3);       // returns 3
     * cache.get(4);       // returns 4
     * <p>
     * 题意：LRU:频率RU..频率相同的移除最近不使用的元素；跟LRU相比，有一个使用频率
     * solution: 两个HashMap 分别存。。valueHash 用于存储Key查询使用。nodeHash用存储<Key,Node></>于内部操作。 LinkedHashSet用于存储count 不同的每个count下的Node的Key.
     * O（1）所以用HashTable(HashMap).最后是一个double链表  Node(count = 0)-Node(count = 1)-Node(count = 2)-Node(count = 3)-Node(count = 4)
     */


    public class LFUCache {
        Node head = null;
        int cap = 0;
        HashMap<Integer, Integer> valueHash = null;
        HashMap<Integer, Node> nodeHash = null;


        public LFUCache(int capacity) {
            this.cap = capacity;
            valueHash = new HashMap<Integer, Integer>();
            nodeHash = new HashMap<Integer, Node>();
        }

        public int get(int key) {
            if (valueHash.containsKey(key)){
                increaseCount(key);
                return valueHash.get(key);
            }

            return -1;
        }

        public void put(int key, int value) {
            if (cap == 0) return;
            if (valueHash.containsKey(key)){
                valueHash.put(key,value);//覆盖
            }else {
                if (valueHash.size() < cap){
                    valueHash.put(key,value);
                }else {
                    removeOld();
                    valueHash.put(key,value);
                }

                addToHead(key);
            }
            increaseCount(key);
        }



        private void addToHead(int key) {
            if (head == null) {
                head = new Node(0);
                head.keys.add(key);
            } else if (head.count > 0) {
                Node node =new Node(0);
                node.keys.add(key);
                node.next = head;
                head.pre = node;
                head = node;
                // 这里count 为0。。。
            }else{//head.count == 0
                head.keys.add(key);
            }
            nodeHash.put(key,head);
        }

        // 新增一个count的Node
        private void increaseCount(int key){
            Node node = nodeHash.get(key);
            node.keys.remove(key);

            if (node.next == null){
                node.next = new Node(node.count+1);
                node.next.pre = node;
                node.next.keys.add(key);
            }else if (node.next.count == node.count+1){
                node.next.keys.add(key);
            }else {//node.next.count > node.count+1
                Node temp = new Node(node.count+1);
                temp.keys.add(key);
                temp.pre = node;
                temp.next = node.next;
                node.next.pre = temp;
                node.next = temp;
            }

            nodeHash.put(key,node.next);
            if (node.keys.size()==0) remove(node);
        }

        private void removeOld() {
            if (head == null) return;
            int old = 0;
            for (int n : head.keys) { // head key 最小
                old = n;
                break;
            }
            head.keys.remove(old);
            if (head.keys.size() == 0) remove(head);
            nodeHash.remove(old);
            valueHash.remove(old);
        }

        private void remove(Node node) {
            // pre
            if (node.pre == null) { //node is head
                head = node.next;
            } else { // has pre
                node.pre.next = node.next;
            }

            //next
            if (node.next != null) {
                node.next.pre = node.pre;
            }
        }


        class Node { // double linked
            public int count = 0;
            public LinkedHashSet<Integer> keys = null;
            public Node pre = null;
            public Node next = null;

            public Node(int count) {
                this.count = count;
                keys = new LinkedHashSet<>();
                pre = next = null;
            }
        }
    }
}
