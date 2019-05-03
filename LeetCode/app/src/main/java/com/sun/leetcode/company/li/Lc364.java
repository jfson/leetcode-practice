package com.sun.leetcode.company.li;

import com.sun.leetcode.model.NestedInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: jfson sun
 * Create on:  2019/5/3
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc364 {
    /**
     * 364. Nested List Weight Sum II
     * Medium
     * <p>
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
     * <p>
     * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
     * <p>
     * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
     * <p>
     * Example 1:
     * <p>
     * Input: [[1,1],2,[1,1]]
     * Output: 8
     * Explanation: Four 1's at depth 1, one 2 at depth 2.
     * Example 2:
     * <p>
     * Input: [1,[4,[6]]]
     * Output: 17
     * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
     * 题意：先进行深度计算
     * solution：dfs
     */

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = getDepth(nestedList);

        return getSum(nestedList,depth);
    }

    private int getSum(List<NestedInteger> nestedList,int depth){
        int ret = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()){
                ret += depth * nestedList.get(i).getInteger();
            }else {
                ret += getSum(nestedList.get(i).getList(),depth-1);
            }
        }
        return  ret;
    }


    private int getDepth(List<NestedInteger> nestedList) {
        int max = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (!nestedInteger.isInteger()) {
                max = Math.max(max, getDepth(nestedInteger.getList()));
            }
        }

        return 1 + max;
    }


}
