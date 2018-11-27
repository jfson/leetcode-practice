package com.sun.leetcode.differentkind.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2018/11/27
 * Question:
 * Description:
 * Train of thought:
 */
public class LcMedium763 {
    /**
     * 763. Partition Labels
     * <p>
     * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
     * <p>
     * Example 1:
     * Input: S = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
     * Note:
     * 1. S will have length in range [1, 500].
     * 2. S will consist of lowercase letters ('a' to 'z') only.
     * <p>
     * 题意：划分，每个字符在一个part..
     * solution:根据一个start的字符找到该字符end,查看区间的字符是否在区间外，区间外则扩充(时间复杂度O(n^2)) 所以用HashTable优化,用空间换时间。
     * 这时候会遍历两遍，第一遍将26个字符每个end位置记录下来，第二遍去查看是否需要扩充
     * Greedy,hashtable
     */

    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;
        int[] lastPosition = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastPosition[S.charAt(i) - 'a'] = i;
        }

        List<Integer> list = new ArrayList<>();
        int start = 0;
        int last = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastPosition[S.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }

        return list;
    }
}
