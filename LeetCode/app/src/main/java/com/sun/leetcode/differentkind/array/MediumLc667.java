package com.sun.leetcode.differentkind.array;

/**
 * Author: jfson sun
 * Create on:  2018/11/1
 * Question:667. Beautiful Arrangement II
 * Description:
 * Train of thought:
 */
public class MediumLc667 {
    /**
     Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
     Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

     If there are multiple answers, print any of them.

     Example 1:
     Input: n = 3, k = 1
     Output: [1, 2, 3]
     Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
     Example 2:
     Input: n = 3, k = 2
     Output: [1, 3, 2]
     Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
     Note:
     The n and k are in the range 1 <= k < n <= 104.

     题意：求1-n构成的数组的一个序，这个序要满足两两之间元素差的绝对值（相同的值算一种情况）构成的数组大小为k。返回满足条件的数组序列。
     思路：两两差
     */

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];

        return res;
    }

}
