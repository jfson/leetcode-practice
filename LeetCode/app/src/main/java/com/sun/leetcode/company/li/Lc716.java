package com.sun.leetcode.company.li;

import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2019/5/3
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc716 {
    /**
     716. Max Stack
     Easy

     Design a max stack that supports push, pop, top, peekMax and popMax.

     push(x) -- Push element x onto stack.
     pop() -- Remove the element on top of the stack and return it.
     top() -- Get the element on the top.
     peekMax() -- Retrieve the maximum element in the stack.
     popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
     Example 1:
     MaxStack stack = new MaxStack();
     stack.push(5);
     stack.push(1);
     stack.push(5);
     stack.top(); -> 5
     stack.popMax(); -> 5
     stack.top(); -> 1
     stack.peekMax(); -> 5
     stack.pop(); -> 1
     stack.top(); -> 5
     Note:
     -1e7 <= x <= 1e7
     Number of operations won't exceed 10000.
     The last four operations won't be called when stack is empty.
     题意：实现一个最大栈，包含一般栈的功能，但是还新加了两个功能peekMax()和popMax()，
     随时随地可以查看和返回最大值。之前有一道很类似的题Min Stack，所以我们可以借鉴那道题的解法，
     使用两个栈来模拟，s1为普通的栈，用来保存所有的数字，而s2为最大栈，用来保存出现的最大的数字。
     solution：
     */

    class MaxStack {
        Stack<Integer> stack;
        Stack<Integer> maxStack;

        /**
         * initialize your data structure here.
         */
        public MaxStack() {
            stack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            pushHelper(x);
        }

        public void pushHelper(int x) {
            int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
            if (x > tempMax) {
                tempMax = x;
            }
            stack.push(x);
            maxStack.push(tempMax);
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = maxStack.peek();
            Stack<Integer> temp = new Stack<>();

            while (stack.peek() != max) {
                temp.push(stack.pop());
                maxStack.pop();
            }
            stack.pop();
            maxStack.pop();
            while (!temp.isEmpty()) {
                int x = temp.pop();
                pushHelper(x);
            }
            return max;
        }
    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
}
