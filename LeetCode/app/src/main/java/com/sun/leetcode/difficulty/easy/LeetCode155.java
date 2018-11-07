package com.sun.leetcode.difficulty.easy;

import java.util.ArrayList;

/**
 * Author: jfson sun
 * Create on:  2018/10/2
 * Question:    155. Min Stack
 * Description:
 * Train of thought:
 */
public class LeetCode155 {
//    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//            push(x) -- Push element x onto stack.
//            pop() -- Removes the element on top of the stack.
//    top() -- Get the top element.
//    getMin() -- Retrieve the minimum element in the stack.

//    MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//            minStack.pop();
//minStack.top();      --> Returns 0.
//            minStack.getMin();   --> Returns -2.

    class MinStack {
        private ArrayList<Integer> list;

        public MinStack() {
            list = new ArrayList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public void pop() {
            if (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }
        }

        public int top() {
            if (list.isEmpty()) {
                return 0;
            }
            return list.get(list.size() - 1);
        }

        public int getMin() {

            int num = 0;

            if (!list.isEmpty()) {
                num = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    if (num > list.get(i)) {
                        num = list.get(i);
                    }
                }
            }
            return num;
        }
    }


}
