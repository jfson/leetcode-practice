package com.sun.leetcode.jianzhioffer;

import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2020/3/22
 * Question:
 * Description:
 * Train of thought:
 */
public class Array06 {

    /**
     用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    public class Solution {
        //[0,1,2,3,4,5]
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();


        //每次psuh是时先将stack2清空放入stck1(保证选入的一定在栈底)，stack2始终是用来删除的
//在pop前，先将stack1中中的数据清空放入stack2（保存后入的在栈底），stack1始终用于push
        public void push(int node) {
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }

        public int pop() {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
