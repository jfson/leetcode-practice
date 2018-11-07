package com.sun.leetcode.difficulty.easy;

/**
 * Author: jfson sun
 * Create on:  2018/9/27
 * Question:    58. Length of Last Word
 * Description: Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Train of thought:
 */
public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        String[] a = s.split(" ");

        if (a == null || a.length == 0) return 0;

        return a[a.length - 1].length();
    }
}
