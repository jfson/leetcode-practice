package com.sun.leetcode.differentkind.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: jfson sun
 * Create on:  2018/10/30
 * Question: 888. Fair Candy Swap
 * Description:
 * Train of thought:
 */
public class EasyLc888 {

    /**
     * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
     * <p>
     * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
     * <p>
     * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
     * <p>
     * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
     * <p>
     * 题意：A - B 各选一个数交换位置，最后和相等
     * <p>
     * <p>
     * Input: A = [1,1], B = [2,2]
     * Output: [1,2]
     * <p>
     * Input: A = [1,2,5], B = [2,4]
     * Output: [5,4]
     */

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            sumA += i;
            set.add(i);
        }
        for (int i : B) {
            sumB += i;
        }

        for (int i = 0; i < B.length; i++) {
            int x = B[i] + (sumA - sumB) / 2;
            if (set.contains(x)) return new int[]{x, B[i]};
        }

        return new int[0];
    }
}
