package com.sun.leetcode.company.li;

import com.sun.leetcode.model.NestedInteger;

import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/5/3
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc339 {
    /**
     Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

     Each element is either an integer, or a list -- whose elements may also be integers or other lists.

     Example 1:

     Input: [[1,1],2,[1,1]]
     Output: 10
     Explanation: Four 1's at depth 2, one 2 at depth 1.
     Example 2:

     Input: [1,[4,[6]]]
     Output: 27
     Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
     题意：返回所有元素的和。并且根据深度进行加权计算。num 乘其 深度
     solution:
     */

    public int depthSum(List<NestedInteger> nestedList) {


        return helper(nestedList,1);
    }

    public int helper(List<NestedInteger> list,int level){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isInteger()){
                sum += list.get(i).getInteger() * level;
            }else {
                sum += helper(list.get(i).getList(),level+1);
            }
        }

        return sum;
    }
}
