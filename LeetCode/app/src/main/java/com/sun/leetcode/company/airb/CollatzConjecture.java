package com.sun.leetcode.company.airb;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: jfson sun
 * Create on:  2019/1/2
 * Question:
 * Description:
 * Train of thought:
 */
public class CollatzConjecture {
    /*
       Collatz Conjecture
       考拉兹猜想
       AirBnB Interview Question
       https://en.wikipedia.org/wiki/Collatz_conjecture
       如果是偶数就 除2，奇数就乘3 + 1，最后得到1，步数 为 x
       然后有 1， 2， 3， ..., n 个数，求最长的步长。。。复杂度 O(n)。理想情况下
       solution:递归
    */
    public class Solution {
        private int findSteps(int num) {
            if (num <= 1) return 1;
            if (num % 2 == 0) return 1 + findSteps(num / 2);
            return 1 + findSteps(3 * num + 1);
        }

        public int findLongestSteps(int num) {
            if (num < 1) return 0;

            int res = 0;
            for (int i = 1; i <= num; i++) {
                int t = findSteps(i);
                res = Math.max(res, t);
            }

            return res;
        }
    }

    /*
        Collatz Conjecture - Memorization
        AirBnB Interview Question
        https://en.wikipedia.org/wiki/Collatz_conjecture
     */
    public class Solution_2 {
        Map<Integer, Integer> map = new HashMap<>();

        private int findSteps(int num) {
            if (num <= 1) return 1;
            if (map.containsKey(num)) return map.get(num);
            if (num % 2 == 0) num = num / 2;
            else num = 3 * num + 1;
            if (map.containsKey(num)) return map.get(num) + 1;
            int t = findSteps(num);
            map.put(num, t);
            return t + 1;
        }

        public int findLongestSteps(int num) {
            if (num < 1) return 0;

            int res = 0;
            for (int i = 1; i <= num; i++) {
                int t = findSteps(i);
                map.put(i, t);
                res = Math.max(res, t);
            }

            return res;
        }
    }

}
