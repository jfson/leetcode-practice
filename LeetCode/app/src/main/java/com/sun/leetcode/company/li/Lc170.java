package com.sun.leetcode.company.li;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: jfson sun
 * Create on:  2019/5/3
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc170 {
    /**
     170. Two Sum III - Data structure design
     Easy

     Design and implement a TwoSum class. It should support the following operations: add and find.

     add - Add the number to an internal data structure.
     find - Find if there exists any pair of numbers which sum is equal to the value.

     Example 1:

     add(1); add(3); add(5);
     find(4) -> true
     find(7) -> false
     Example 2:

     add(3); add(1); add(2);
     find(3) -> true
     find(6) -> false
     */

    /** Initialize your data structure here. */


    /**
     * Your TwoSum object will be instantiated and called as such:
     * TwoSum obj = new TwoSum();
     * obj.add(number);
     * boolean param_2 = obj.find(value);
     */
    class TwoSum {
        private List<Integer> list;
        private Map<Integer, Integer> map;

        /** Initialize your data structure here. */
        public TwoSum() {
            list = new ArrayList<>();
            map = new HashMap<Integer, Integer>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if (map.containsKey(number)){
                map.put(number,map.get(number)+1);
            }else {
                list.add(number);
                map.put(number,1);
            }
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (int i = 0; i < list.size(); i++) {
                int num1 = list.get(i),num2 = value - num1;
                if (num1 == num2 && map.get(num1) > 1){
                    return true;
                }

                if (num1 != num2 && map.containsKey(num2)){
                    return true;
                }
            }

            return false;
        }
    }

}
