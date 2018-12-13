package com.sun.leetcode.company.snap;

import java.util.HashMap;

/**
 * Author: jfson sun
 * Create on:  2018/12/13
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc146 {
    /**
     * 146. LRU Cache
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     * <p>
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     * <p>
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     * <p>
     * Example:
     * <p>
     * LRUCache cache = new LRUCache( 2 /* capacity  );
     * <p>
     * cache.put(1, 1);
     * cache.put(2, 2);
     * cache.get(1);       // returns 1
     * cache.put(3, 3);    // evicts key 2
     * cache.get(2);       // returns -1 (not found)
     * cache.put(4, 4);    // evicts key 1
     * cache.get(1);       // returns -1 (not found)
     * cache.get(3);       // returns 3
     * cache.get(4);       // returns 4
     * cache.get(4);       // returns 4
     * <p>
     * 题意： LRU
     * solution: O（1），所以是hash table makes the time of get() to be O(1)，不是List
     */

    class LRUCache {
        HashMap<Integer, Node> map;
        int capicity, count;
        Node start, end;

        public LRUCache(int capacity) {
            this.capicity = capacity;
            map = new HashMap<>();
            start = new Node(0, 0);
            end = new Node(0, 0);
            start.next = end;
            end.pre = start;
            start.pre = null;
            end.next = null;
            count = 0;
        }

        public void deleteNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addToHead(Node node) {
            node.next = start.next;
            node.next.pre = node;
            node.pre = start;
            start.next = node;
        }

        public int get(int key) {
            if (map.get(key) != null) {
                Node node = map.get(key);
                int result = node.value;
                deleteNode(node);
                addToHead(node);
                return result;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.get(key) != null) {// has key
                Node node = map.get(key);
                node.value = value;
                deleteNode(node);
                addToHead(node);
            } else {
                Node node = new Node(key, value);
                map.put(key, node);
                if (count < capicity) {
                    count++;
                    addToHead(node);
                } else {
                    // 由于加了一个end,所以是end.pre
                    map.remove(end.pre.key);
                    deleteNode(end.pre);
                    addToHead(node);
                }
            }
        }

        class Node { // double linked
            int key;
            int value;
            Node pre;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
