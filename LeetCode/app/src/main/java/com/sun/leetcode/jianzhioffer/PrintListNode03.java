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
     *
     * 递归的概念
     */



    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(list,listNode);

        Collections.reverse(list);
        return list;
    }

    // (0,next-> 1)
    // (1,next-> 2)
    // (2,next-> 3)
    // (3,next-> null)
    // 0-1-2-3-null
    public void helper(ArrayList<Integer> ret,ListNode node){
        if (node == null){
            return;
        }
        //0 ,1,2,3,
        ret.add(node.val);
        helper(ret,node.next);
    }




    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // (0,next-> 1)
        // (1,next-> 2)
        // (2,next-> 3)
        // (3,next-> null)
        // 0-1-2-3-null

        ArrayList<Integer> list = new ArrayList<>();

        //安全校验
        if (listNode == null){
            return list;
        }

        //从头到尾
        //size length 概念
        // 0 1 2 3 null
        while (listNode != null){
            list.add(listNode.val);// 0 1 2 3
            listNode = listNode.next;// 1 2 3 null
        }

        //0 1 2 3
        //从尾到头
        Collections.reverse(list);

        return list;
    }

    public void reverse(ArrayList<Integer> list){
        //list length 6; ndex 5
        //0- 5;1-4;2-3;

        for (int i = 0; i < list.size()/2; i++) {
            int temp = list.get(i);
            list.set(i,list.get(list.size()-1-i));//i
            list.set(list.size()-1-i,temp);
        }
    }









//        ArrayList<Integer> ret = new ArrayList();
//        if(listNode == null){
//            return ret;
//        }
//
//        while(listNode != null){
//            ret.add(listNode.val);
//            listNode = listNode.next;
//        }
//
//        Collections.reverse(ret);
//
//        return ret;
//    }
}
