package com.sun.leetcode.difficulty.medium;

import java.util.Arrays;

/**
 * Author: jfson sun
 * Create on:  2018/10/3
 * Question:    3. Longest Substring Without Repeating Characters
 * Description: Given a string, find the length of the longest substring without repeating characters.
 * Train of thought:
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        final int ASCII_MAX = 255;
        int[] last = new int[ASCII_MAX]; // 记录字符上次出现过的位置
        int start = 0; // 记录当前子串的起始位置

        Arrays.fill(last, -1);

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (last[s.charAt(i)] >= start) { // 包含
                maxLength = Math.max(i - start, maxLength);
                start = last[s.charAt(i)] + 1;
            }

            last[s.charAt(i)] = i;
        }


        return Math.max(maxLength,s.length() - start);
    }
}
