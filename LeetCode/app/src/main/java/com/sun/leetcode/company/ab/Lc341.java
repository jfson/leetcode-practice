package com.sun.leetcode.company.ab;

import com.sun.leetcode.model.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2018/12/6
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc341 {
    /**
     341. Flatten Nested List Iterator
     DescriptionHintsSubmissionsDiscussSolution
     Given a nested list of integers, implement an iterator to flatten it.

     Each element is either an integer, or a list -- whose elements may also be integers or other lists.

     Example 1:

     Input: [[1,1],2,[1,1]]
     Output: [1,1,2,1,1]
     Explanation: By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,1,2,1,1].
     Example 2:

     Input: [1,[4,[6]]]
     Output: [1,4,6]
     Explanation: By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,4,6].
     题意： 把一个嵌套的数组迭代对象压平。

     */

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */

    class NestedIterator implements Iterator<Integer> {
        private Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger peek = stack.peek();
                if (peek.isInteger()) return true;

                peek = stack.pop();
                for (int i = peek.getList().size() - 1; i >= 0; i--) {
                    stack.push(peek.getList().get(i));
                }
            }

            return false;
        }
    }
}
