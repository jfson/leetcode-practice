package com.sun.leetcode.company.ab;

import java.util.Iterator;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/12/24
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc251 {
    /**
     251. Flatten 2D Vector
     DescriptionHintsSubmissionsDiscussSolution
     Implement an iterator to flatten a 2d vector.

     Example:

     Input: 2d vector =
     [
     [1,2],
     [3],
     [4,5,6]
     ]
     Output: [1,2,3,4,5,6]
     Explanation: By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,2,3,4,5,6].
     Follow up:
     As an added challenge, try to code it using only iterators in C++ or iterators in Java.

     */

    public class Vector2D implements Iterator<Integer> {
        int indexList,indexEle;
        List<List<Integer>> res;

        public Vector2D(List<List<Integer>> vec2d) {
            res = vec2d;
            indexList = 0;
            indexEle = 0;
        }

        @Override
        public Integer next() {
            return res.get(indexList).get(indexEle++);
        }

        @Override
        public boolean hasNext() {
            while (indexList < res.size()){
                if (indexEle  < res.get(indexList).size()){
                    return true;
                }else {
                    indexList++;
                    indexEle = 0;
                }
            }

            return false;
        }
    }


    /**
     * Your Vector2D object will be instantiated and called as such:
     * Vector2D i = new Vector2D(vec2d);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
