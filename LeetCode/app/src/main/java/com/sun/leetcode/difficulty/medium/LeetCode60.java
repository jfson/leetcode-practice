package com.sun.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/10/12
 * Question:    60. Permutation Sequence
 * Description: The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * Train of thought:
 */
public class LeetCode60 {
    /**
     * 1,2,3,4
     * 1 + {2,3,4}
     * 2 + {1,3,4}
     * 3 + {1,2,4}
     * 4 + {2,3,4}
     */

    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }

        // 全排列个数
        int[] fact = new int[n];
        fact[0] = 1;

        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }

        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k/fact[i-1];
            k = k % fact[i-1];
        }

        return "";
    }
}
