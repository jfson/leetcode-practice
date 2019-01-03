package com.sun.leetcode.company.ab;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/1/2
 * Question:
 * Description:
 * Train of thought:
 */
public class ImplementQueue {
    /**
     实现以个QUEUE
     Implement Queue with Limited Size of Array

     题意：实现QUEUE,限制Array的size,queue不限制长度
     solution:Array..每个Array 存9个元素和一个Array,Array就相当于索引.fixedSize - 1为关键点


     面经：
     implement一个queue，但是要求用int[]储存，并且一次生成的int[]长度不可以超过5。
     其实这是一个内存分配的模型，每个int[]可以看成一个block的抽象，每次需要加更多元素的时候就要申请多分配block，
     remove的时候就要回收block。标准做法是用linkedlist，
     结果秀逗了用了tree，面试官居然就让我这么写了，他多追问一下我就想出来了。不过还好过了。
     */

    private int fixedSize;
    private int head;//头部
    private int tail;//尾部
    private int count;
    private List<Object> headList;
    private List<Object> tailList;


    public ImplementQueue(int fixedSize){
        this.fixedSize = fixedSize;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.headList = new ArrayList<>();
        this.tailList = this.headList;
    }

    public void offer(int num){
        if (tail == fixedSize - 1){
            List<Object> newList = new ArrayList<>();
            newList.add(num);
            tailList.add(newList);
            tailList = (List<Object>) tailList.get(tail);
            tail = 0;
        }else {
            tailList.add(num);
        }
        count++;
        tail++;
    }

    /**
     offer 过程 fixedSize = 5
     [1,2,3,4] --> offer --> [1,2,3,4,[5]] --> tailList = [5]

     poll 过程
     [1,2,3,4,[5]] --> poll --> 1 --> [1,2,3,4,[5]]
     head = 4 --> [5]

     */


    public Integer poll(){
        if (count == 0) return null;

        int num = (int) headList.get(head);
        head++;
        count--;

        if (head == fixedSize -1){
            List<Object> newList = (List<Object>) headList.get(head);
            headList.clear();
            headList = newList;
            head = 0;
        }

        return num;
    }

    public int size(){
        return count;
    }

}
